package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.model.response.SupplierItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierItemMapper {
    public SupplierItemResponse toResponse(SupplierItemEntity entity) {
        SupplierItemResponse response = new SupplierItemResponse();
        response.setId(entity.getId());
        response.setDescription(entity.getDescription());
        response.setAvailability(entity.getAvailability().getName());
        response.setSupplierItemName(entity.getName());
        response.setUnitCost(entity.getUnitCost());
        response.setSupplierName(entity.getSupplier().getName());

        return response;
    }
}
