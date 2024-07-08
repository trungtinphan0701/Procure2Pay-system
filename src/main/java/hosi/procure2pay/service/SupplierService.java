package hosi.procure2pay.service;


import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.response.CreateSupplierResponse;

public interface SupplierService {
    CreateSupplierResponse addSupplier(CreateSupplierRequest request);
}
