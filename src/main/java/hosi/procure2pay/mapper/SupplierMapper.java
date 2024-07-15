package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.response.Supplier.CreateSupplierResponse;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.model.response.Supplier.UpdateSupplierResponse;
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

    public UpdateSupplierResponse toUpdateSupplierResponse(SupplierEntity supplier) {
        UpdateSupplierResponse response = new UpdateSupplierResponse();
        response.setId(supplier.getId());
        response.setName(supplier.getName());
        response.setAddress(supplier.getAddress());
        response.setPhoneNumber(supplier.getPhoneNumber());
        return response;
    }

//    public GetGeneralSupplierInfoResponse toGetGeneralSupplierInfoResponse(SupplierEntity supplier) {
//        GetGeneralSupplierInfoResponse response = new GetGeneralSupplierInfoResponse();
//        response.setId(supplier.getId());
//        response.setName(supplier.getName());
//        response.setPhone(supplier.getPhoneNumber());
//        response.setAddress(supplier.getAddress());
//        response.setSupplierItemEntityList(supplier.getSupplierItems());
//        return response;
//    }
}
