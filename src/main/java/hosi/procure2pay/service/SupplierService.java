package hosi.procure2pay.service;


import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.request.UpdateSupplierRequest;
import hosi.procure2pay.model.response.CreateSupplierResponse;
import hosi.procure2pay.model.response.UpdateSupplierResponse;

public interface SupplierService {
    CreateSupplierResponse addSupplier(CreateSupplierRequest request);
    UpdateSupplierResponse updateSupplier(UpdateSupplierRequest request);
    CreateSupplierResponse deleteSupplier(Integer id);
}
