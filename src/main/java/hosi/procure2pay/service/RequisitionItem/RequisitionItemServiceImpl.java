package hosi.procure2pay.service.RequisitionItem;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.RequisitionItemMapper;
import hosi.procure2pay.model.request.RequisitionItem.CreateRequisitionItemRequest;
import hosi.procure2pay.model.request.RequisitionItem.UpdateRequisitionItemRequest;
import hosi.procure2pay.model.response.RequisitionItem.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.RequisitionItem.UpdateRequisitionItemResponse;
import hosi.procure2pay.service.Requisition.RequisitionRepoService;
import hosi.procure2pay.service.SupplierItem.SupplierItemRepoService;
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

    // create requisition item based on input (requisition id and supplier item id)
    // if supplier item comes from supplier that has different id with one in requisition -> throw exception
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
        requisition.setTotalCost(requisition.getTotalCost() + requisitionItem.getTotalCost());
        requisitionRepoService.save(requisition);
        CreateRequisitionItemResponse response = requisitionItemMapper.toRequisitionItemResponse(requisitionItem);
        return response;
    }

    // update requisition item based on requisition id and supplier item id
    @Override
    public UpdateRequisitionItemResponse updateRequisitionItem(UpdateRequisitionItemRequest request) {
        RequisitionItemEntity requisitionItem = requisitionItemRepoService.findByRequisitionIdAndSupplierItemId(request.getRequisitionId(), request.getSupplierItemId());

        SupplierItemEntity supplierItem = supplierItemRepoService.findById(request.getSupplierItemId());
        requisitionItem.setQuantity(request.getQuantity());
        requisitionItem.setTotalCost(request.getQuantity()*supplierItem.getUnitCost());
        requisitionItemRepoService.save(requisitionItem);
        UpdateRequisitionItemResponse updateRequisitionItemResponse = requisitionItemMapper.toUpdateRequisitionItemResponse(requisitionItem);
        return updateRequisitionItemResponse;
    }

    // delete requisition item based on its id
    // first find its requisition item -> delete -> return deleted version?
    @Override
    public CreateRequisitionItemResponse deleteRequisitionItem(Integer id) {
        RequisitionItemEntity requisitionItem = requisitionItemRepoService.findById(id);
        requisitionItemRepoService.delete(id);
        return requisitionItemMapper.toRequisitionItemResponse(requisitionItem);
    }
}
