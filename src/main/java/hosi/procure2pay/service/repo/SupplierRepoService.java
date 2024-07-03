package hosi.procure2pay.service.repo;

import hosi.procure2pay.entity.SupplierEntity;

public interface SupplierRepoService {
    SupplierEntity save(SupplierEntity supplier);
    SupplierEntity findById(Integer id);
}
