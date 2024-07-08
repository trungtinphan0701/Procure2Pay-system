package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.response.CreateSupplierResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierMapper {
    public CreateSupplierResponse toCreateSupplierResponse(SupplierEntity supplier) {
        CreateSupplierResponse response = new CreateSupplierResponse();
        response.setSupplierId(supplier.getId());
        response.setSupplierName(supplier.getName());
        response.setAddress(supplier.getAddress());
        response.setPhoneNumber(supplier.getPhoneNumber());
        return response;
    }
}
