package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionMapper;
import hosi.procure2pay.model.enums.RequisitionState;
import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.RequisitionResponse;
import hosi.procure2pay.service.*;
import hosi.procure2pay.service.UserRepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RequisitionServiceImpl implements RequisitionService {
    private RequisitionRepoService requisitionRepoService;
    private UserRepoService userRepoService;
    private SupplierRepoService supplierRepoService;
    private RequisitionMapper requisitionMapper;

    @Override
    public RequisitionResponse createRequisition(CreateRequisitionRequest requisitionRequest) {
        this.handleRequisitionRequest(requisitionRequest);

        // Find user entity by id:
        UserEntity userEntity = userRepoService.findById(requisitionRequest.getUserId());
        SupplierEntity supplierEntity = supplierRepoService.findById(requisitionRequest.getSupplierId());


        // Map user entity to requisition entity:
        RequisitionEntity requisitionEntity = new RequisitionEntity();
        requisitionEntity.setCreatedBy(userEntity);
        requisitionEntity.setSupplier(supplierEntity);

        // Default values:
        requisitionEntity.setCreatedOn(LocalDateTime.now());
        requisitionEntity.setTotalCost(0.0f);
        requisitionEntity.setState(RequisitionState.AWAITING_APPROVAL);

        // Create requisition entity:
        RequisitionEntity createdRequisitionEntity = requisitionRepoService.save(requisitionEntity);

        RequisitionResponse response = requisitionMapper.toResponse(createdRequisitionEntity);

        return response;
    }

    private void handleRequisitionRequest(CreateRequisitionRequest requisitionRequest) {
        if (requisitionRequest.getUserId() == null) {
            throw new ResponseException(BadRequestError.USER_ID_INVALID);
        }

        if (requisitionRequest.getSupplierId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_INVALID);
        }
    }
}
