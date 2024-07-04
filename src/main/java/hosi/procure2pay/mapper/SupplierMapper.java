package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.response.SupplierResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierMapper {

    public SupplierResponse toResponse(SupplierEntity entity) {
        SupplierResponse response = new SupplierResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setAddress(entity.getAddress());
        response.setPhoneNumber(entity.getPhoneNumber());
        return response;
    }
}
