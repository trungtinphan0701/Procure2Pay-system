package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionMapper;
import hosi.procure2pay.model.enums.RequisitionState;
import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import hosi.procure2pay.service.RequisitionService;
import hosi.procure2pay.service.repo.RequisitionRepoService;
import hosi.procure2pay.service.repo.SupplierRepoService;
import hosi.procure2pay.service.repo.UserRepoService;
import lombok.RequiredArgsConstructor;
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
        if (request.getUserId() == null) {
            throw new ResponseException(BadRequestError.USER_ID_NULL);
        }
        if (request.getSupplierId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
        }
        UserEntity user = userRepoService.findById(request.getUserId());
        SupplierEntity supplier = supplierRepoService.findById(request.getSupplierId());

        RequisitionEntity requisition = new RequisitionEntity();
        requisition.setCreatedByUser(user);
        requisition.setCreatedOn(LocalDateTime.now());
        requisition.setState(RequisitionState.AWAITING_APPROVAL);
        requisition.setTotalCost(0.0f);
        requisition.setSupplierEntity(supplier);
        requisitionRepoService.save(requisition);

        CreateRequisitionResponse response = requisitionMapper.toRequisitionResponse(requisition);
        return response;
    }
}
