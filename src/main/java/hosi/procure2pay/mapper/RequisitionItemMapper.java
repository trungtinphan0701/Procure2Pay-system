package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.model.response.RequisitionItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequisitionItemMapper {

    public RequisitionItemResponse toResponse(RequisitionItemEntity requisitionItemEntity)  {
        RequisitionItemResponse requisitionItemResponse = new RequisitionItemResponse();
        requisitionItemResponse.setSupplierName(requisitionItemEntity.getSupplierItem().getSupplier().getName());
        requisitionItemResponse.setItemName(requisitionItemEntity.getSupplierItem().getName());
        requisitionItemResponse.setItemDescription(requisitionItemEntity.getSupplierItem().getDescription());
        requisitionItemResponse.setQuantity(requisitionItemEntity.getQuantity());
        requisitionItemResponse.setUnitPrice(requisitionItemEntity.getSupplierItem().getUnitCost());
        requisitionItemResponse.setTotalPrice(requisitionItemEntity.getTotalItemCost());

        return requisitionItemResponse;
    }
}
