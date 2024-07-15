package hosi.procure2pay.service.Requisition;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.model.request.Requisition.SearchRequisitionRequest;
import org.springframework.data.domain.Page;

public interface RequisitionRepoService {
    RequisitionEntity save(RequisitionEntity requisition);
    RequisitionEntity findById(Integer id);
    Page<RequisitionEntity> searchRequisition(SearchRequisitionRequest request);
}
