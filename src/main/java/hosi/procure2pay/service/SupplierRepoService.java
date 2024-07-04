package hosi.procure2pay.service;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.response.SupplierResponse;

public interface SupplierRepoService {
    SupplierEntity save(SupplierEntity supplierEntity);
    SupplierEntity findById(Integer id);
}
