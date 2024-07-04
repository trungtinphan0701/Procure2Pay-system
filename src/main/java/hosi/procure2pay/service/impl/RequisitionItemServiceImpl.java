package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionItemMapper;
import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.response.RequisitionItemResponse;
import hosi.procure2pay.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisitionItemServiceImpl implements RequisitionItemService {
    private final RequisitionItemRepoService requisitionItemRepoService;
    private final RequisitionRepoService requisitionRepoService;
    private final SupplierItemRepoService supplierItemRepoService;
    private final RequisitionItemMapper requisitionItemMapper;

    @Override
    public RequisitionItemResponse createRequisitionItem(CreateRequisitionItemRequest requisitionItemRequest) {
        this.handleRequisitionItemRequest(requisitionItemRequest);

        RequisitionEntity requisitionEntity = requisitionRepoService.findById(requisitionItemRequest.getRequisitionId());
        SupplierItemEntity supplierItemEntity = supplierItemRepoService.findById(requisitionItemRequest.getSupplierItemId());

        RequisitionItemEntity requisitionItemEntity = new RequisitionItemEntity();
        requisitionItemEntity.setRequisition(requisitionEntity);
        requisitionItemEntity.setSupplierItem(supplierItemEntity);
        requisitionItemEntity.setQuantity(requisitionItemRequest.getQuantity());
        requisitionItemEntity.setTotalItemCost(supplierItemEntity.getUnitCost() * requisitionItemRequest.getQuantity());

        requisitionItemRepoService.save(requisitionItemEntity);

        return requisitionItemMapper.toResponse(requisitionItemEntity);
    }

    private void handleRequisitionItemRequest(CreateRequisitionItemRequest requisitionItemRequest) {
        if (requisitionItemRequest.getRequisitionId() == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ID_INVALID);
        }

        if (requisitionItemRequest.getSupplierItemId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_ID_INVALID);
        }

        if (requisitionItemRequest.getQuantity() == null) {
            throw new ResponseException(BadRequestError.QUANTITY_INVALID);
        }

        if (requisitionItemRequest.getQuantity() <= 0) {
            throw new ResponseException(BadRequestError.QUANTITY_INVALID);
        }

        if (requisitionItemRequest.getQuantity() > 100) {
            throw new ResponseException(BadRequestError.QUANTITY_INVALID);
        }
    }
}
