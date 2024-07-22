package hosi.procure2pay.service.RequisitionItem;

import hosi.procure2pay.entity.RequisitionItemEntity;

public interface RequisitionItemRepoService {
    RequisitionItemEntity save(RequisitionItemEntity requisitionItemEntity);
    RequisitionItemEntity findByRequisitionIdAndSupplierItemId(Integer requisitionId, Integer supplierItemId);
    RequisitionItemEntity findById(Integer id);
    void delete(Integer id);

}
