package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import hosi.procure2pay.model.response.SupplierItem.UpdateSupplierItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SupplierItemMapper {
    public SupplierItemResponse toSupplierItemResponse (SupplierItemEntity supplierItemEntity) {
        SupplierItemResponse SupplierItemResponse = new SupplierItemResponse();
        SupplierItemResponse.setSupplierName(supplierItemEntity.getSupplier().getName());
        SupplierItemResponse.setSupplierItemName(supplierItemEntity.getName());
        SupplierItemResponse.setState(supplierItemEntity.getState().getStateName());
        SupplierItemResponse.setDescription(supplierItemEntity.getDescription());
        SupplierItemResponse.setType(supplierItemEntity.getType());
        SupplierItemResponse.setUnitCost(supplierItemEntity.getUnitCost());
        SupplierItemResponse.setSupplierItemId(supplierItemEntity.getId());
        return SupplierItemResponse;
    }

    public List<SupplierItemResponse> toSupplierItemResponseList (List<SupplierItemEntity> supplierItemEntities) {
        List<SupplierItemResponse> SupplierItemResponseList = new ArrayList<>();
        for (SupplierItemEntity supplierItemEntity : supplierItemEntities) {
            SupplierItemResponse SupplierItemResponse = this.toSupplierItemResponse(supplierItemEntity);
            SupplierItemResponseList.add(SupplierItemResponse);
        }
        return SupplierItemResponseList;
    }

    public UpdateSupplierItemResponse toUpdateSupplierItemResponse (SupplierItemEntity supplierItemEntity) {
        UpdateSupplierItemResponse SupplierItemResponse = new UpdateSupplierItemResponse();
        SupplierItemResponse.setName(supplierItemEntity.getName());
        SupplierItemResponse.setDescription(supplierItemEntity.getDescription());
        SupplierItemResponse.setType(supplierItemEntity.getType());
        SupplierItemResponse.setUnitCost(supplierItemEntity.getUnitCost());
        SupplierItemResponse.setSupplierItemState(supplierItemEntity.getState());
        return SupplierItemResponse;
    }

}
