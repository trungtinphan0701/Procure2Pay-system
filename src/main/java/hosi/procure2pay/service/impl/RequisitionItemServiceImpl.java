package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionItemMapper;
import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.response.CreateRequisitionItemResponse;
import hosi.procure2pay.service.RequisitionItemService;
import hosi.procure2pay.service.repo.RequisitionItemRepoService;
import hosi.procure2pay.service.repo.RequisitionRepoService;
import hosi.procure2pay.service.repo.SupplierItemRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RequisitionItemServiceImpl implements RequisitionItemService {
    private final RequisitionRepoService requisitionRepoService;
    private final SupplierItemRepoService supplierItemRepoService;
    private final RequisitionItemRepoService requisitionItemRepoService;
    private final RequisitionItemMapper requisitionItemMapper;

    @Override
    public CreateRequisitionItemResponse addRequisitionItem(CreateRequisitionItemRequest request) {
        if (request.getRequisitionId() == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ID_NULL);
        }
        if (request.getSupplierItemId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_ID_NULL);
        }
        RequisitionEntity requisition = requisitionRepoService.findById(request.getRequisitionId());
        SupplierItemEntity supplierItem = supplierItemRepoService.findById(request.getSupplierItemId());

        if (!Objects.equals(requisition.getSupplierEntity().getId(), supplierItem.getSupplier().getId())) {
            throw new ResponseException(BadRequestError.ITEM_NOT_FOUND_IN_THIS_REQUISITION_SUPPLIER);
        }

        RequisitionItemEntity requisitionItem = new RequisitionItemEntity();
        requisitionItem.setRequisition(requisition);
        requisitionItem.setSupplierItem(supplierItem);
        requisitionItem.setQuantity(request.getQuantity());
        requisitionItem.setTotalCost(request.getQuantity()*supplierItem.getUnitCost());
        requisitionItemRepoService.save(requisitionItem);

        CreateRequisitionItemResponse response = requisitionItemMapper.toRequisitionItemResponse(requisitionItem);
        return response;
    }
}
