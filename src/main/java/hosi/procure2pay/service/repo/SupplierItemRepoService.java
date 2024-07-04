package hosi.procure2pay.service.repo;

import hosi.procure2pay.entity.SupplierItemEntity;

public interface SupplierItemRepoService {
    SupplierItemEntity save(SupplierItemEntity supplierItem);
    SupplierItemEntity findById(Integer id);
}
