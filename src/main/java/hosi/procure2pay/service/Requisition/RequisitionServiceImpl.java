package hosi.procure2pay.service.Requisition;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionMapper;
import hosi.procure2pay.model.enums.RequisitionState;
import hosi.procure2pay.model.enums.UserRole;
import hosi.procure2pay.model.request.Requisition.CreateRequisitionRequest;
import hosi.procure2pay.model.request.Requisition.SearchRequisitionRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Requisition.ApproveRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.DeclineRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.GetRequisitionInfoResponse;
import hosi.procure2pay.service.Supplier.SupplierRepoService;
import hosi.procure2pay.service.User.UserRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequisitionServiceImpl implements RequisitionService {
    private final RequisitionRepoService requisitionRepoService;
    private final UserRepoService userRepoService;
    private final SupplierRepoService supplierRepoService;
    private final RequisitionMapper requisitionMapper;

    @Override
    public CreateRequisitionResponse addRequisition(CreateRequisitionRequest request) {
        if (request.getSupplierId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        UserEntity user = userRepoService.findByEmail(currentUser);
        SupplierEntity supplier = supplierRepoService.findById(request.getSupplierId());

        RequisitionEntity requisition = new RequisitionEntity();
        requisition.setCreatedByUser(user);
        requisition.setCreatedOn(LocalDateTime.now());
        requisition.setState(RequisitionState.AWAITING_APPROVAL);
        requisition.setTotalCost(0.0f);
        requisition.setSupplierEntity(supplier);
        requisitionRepoService.save(requisition);
        requisition.setCode("PR" + requisition.getId().toString());
        requisitionRepoService.save(requisition);

        CreateRequisitionResponse response = requisitionMapper.toRequisitionResponse(requisition);
        return response;
    }

    @Override
    public GetRequisitionInfoResponse getRequisitionInfoById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ID_NULL);
        }
        RequisitionEntity requisition = requisitionRepoService.findById(id);
        return requisitionMapper.toRequisitionInfoResponse(requisition);
    }

    @Override
    public ApproveRequisitionResponse approveRequisition(Integer id) {
        RequisitionEntity requisition = requisitionRepoService.findById(id);
        requisition.setState(RequisitionState.APPROVED);
        requisition.setCode("PO"+ id.toString());
        requisitionRepoService.save(requisition);
        return ApproveRequisitionResponse.builder()
                .requisitionId(requisition.getId())
                .state(requisition.getState())
                .build();
    }

    @Override
    public DeclineRequisitionResponse declineRequisition(Integer id) {
        RequisitionEntity requisition = requisitionRepoService.findById(id);
        requisition.setState(RequisitionState.DECLINED);
        requisitionRepoService.save(requisition);
        return DeclineRequisitionResponse.builder()
                .id(requisition.getId())
                .state(requisition.getState())
                .build();
    }

    @Override
    public PagedResult<GetRequisitionInfoResponse> searchRequisition(SearchRequisitionRequest request) {
        this.handleSearchRequisitionRequest(request);
        Page<RequisitionEntity> requisitionEntityPage = requisitionRepoService.searchRequisition(request);
        List<RequisitionEntity> requisitionEntityList = requisitionEntityPage.getContent();

        List<GetRequisitionInfoResponse> getRequisitionInfoResponseList = new ArrayList<>();

        for (RequisitionEntity requisitionEntity : requisitionEntityList) {
            getRequisitionInfoResponseList.add(requisitionMapper.toRequisitionInfoResponse(requisitionEntity));
        }

        return new PagedResult<>(
                getRequisitionInfoResponseList,
                requisitionEntityPage.getTotalPages(),
                requisitionEntityPage.getTotalElements(),
                request.getPageNumber(),
                request.getPageSize());

    }

    private void handleSearchRequisitionRequest(SearchRequisitionRequest request) {
        if (request.getMinTotalCost() > request.getMaxTotalCost()) {
            throw new ResponseException(BadRequestError.MIN_MUST_BE_SMALLER_THAN_MAX);
        }

        if (request.getFromDate() != null && request.getToDate() != null) {
            LocalDate fromDate = LocalDate.parse(request.getFromDate());
            LocalDate toDate = LocalDate.parse(request.getToDate());

            if (fromDate.isAfter(toDate)) {
                throw new ResponseException(BadRequestError.START_DATE_MUST_BE_BEFORE_END_DATE);
            }
        }
    }
}


