package hosi.procure2pay.service.Requisition;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionMapper;
import hosi.procure2pay.model.enums.RequisitionState;
import hosi.procure2pay.model.enums.UserRole;
import hosi.procure2pay.model.request.Requisition.CreateRequisitionRequest;
import hosi.procure2pay.model.response.Requisition.ApproveRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.GetRequisitionInfoResponse;
import hosi.procure2pay.service.Supplier.SupplierRepoService;
import hosi.procure2pay.service.User.UserRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

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
//        if (request.getUserId() == null) {
//            throw new ResponseException(BadRequestError.USER_ID_NULL);
//        }
//        if (request.getSupplierId() == null) {
//            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
//        }
//        UserEntity user = userRepoService.findById(request.getUserId());
//        SupplierEntity supplier = supplierRepoService.findById(request.getSupplierId());
        UserEntity user = userRepoService.findByEmail(currentUser);
        SupplierEntity supplier = supplierRepoService.findById(request.getSupplierId());

        RequisitionEntity requisition = new RequisitionEntity();
        requisition.setCreatedByUser(user);
        requisition.setCreatedOn(LocalDateTime.now());
        if (user.getRole() == UserRole.APPROVER || user.getRole() == UserRole.ADMIN) {
            requisition.setState(RequisitionState.APPROVED);
        } else {
            requisition.setState(RequisitionState.AWAITING_APPROVAL);
        }
        requisition.setTotalCost(0.0f);
        requisition.setSupplierEntity(supplier);
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
        requisitionRepoService.save(requisition);
        return ApproveRequisitionResponse.builder()
                .requisitionId(requisition.getId())
                .state(requisition.getState())
                .build();
    }
}

//    @Override
//    public GetRequisitionInfoResponse createRequisition(CreateRequisitionInfoRequest request) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUser = authentication.getName();
//        UserEntity user = userRepoService.findByEmail(currentUser);
//
//
//    }
//}
