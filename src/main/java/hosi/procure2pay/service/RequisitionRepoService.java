package hosi.procure2pay.service;

import hosi.procure2pay.entity.RequisitionEntity;

public interface RequisitionRepoService {
    RequisitionEntity save(RequisitionEntity requisitionEntity);
    RequisitionEntity findById(Integer requisitionId);
}
