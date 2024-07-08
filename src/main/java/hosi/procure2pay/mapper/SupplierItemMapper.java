package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.model.response.CreateSupplierItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierItemMapper {
    public CreateSupplierItemResponse toSupplierItemResponse (SupplierItemEntity supplierItemEntity) {
        CreateSupplierItemResponse createSupplierItemResponse = new CreateSupplierItemResponse();
        createSupplierItemResponse.setSupplierName(supplierItemEntity.getSupplier().getName());
        createSupplierItemResponse.setState(supplierItemEntity.getState().getStateName());
        createSupplierItemResponse.setDescription(supplierItemEntity.getDescription());
        createSupplierItemResponse.setType(supplierItemEntity.getType());
        createSupplierItemResponse.setUnitCost(supplierItemEntity.getUnitCost());
        createSupplierItemResponse.setSupplierItemId(supplierItemEntity.getId());
        return createSupplierItemResponse;
    }
}
