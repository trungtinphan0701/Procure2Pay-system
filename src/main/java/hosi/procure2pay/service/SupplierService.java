package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.response.SupplierResponse;

public interface SupplierService {
    SupplierResponse createSupplier(CreateSupplierRequest request);
}
