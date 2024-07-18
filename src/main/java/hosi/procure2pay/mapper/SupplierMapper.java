package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.response.Supplier.SupplierInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierMapper {
    public SupplierInfoResponse toCreateSupplierResponse(SupplierEntity supplier) {
        SupplierInfoResponse response = new SupplierInfoResponse();
        response.setSupplierId(supplier.getId());
        response.setSupplierName(supplier.getName());
        response.setAddress(supplier.getAddress());
        response.setPhoneNumber(supplier.getPhoneNumber());
        return response;
    }
}
