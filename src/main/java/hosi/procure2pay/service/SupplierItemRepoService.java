package hosi.procure2pay.service;

import hosi.procure2pay.entity.SupplierItemEntity;

public interface SupplierItemRepoService {
    SupplierItemEntity save(SupplierItemEntity supplierItemEntity);
    SupplierItemEntity findById(Integer supplierItemId);
}
