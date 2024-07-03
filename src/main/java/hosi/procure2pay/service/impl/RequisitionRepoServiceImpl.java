package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.repository.RequisitionRepository;
import hosi.procure2pay.service.RequisitionRepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequisitionRepoServiceImpl implements RequisitionRepoService {
    private RequisitionRepository requisitionRepository;
    @Override
    public RequisitionEntity save(RequisitionEntity requisitionEntity) {
        return requisitionRepository.save(requisitionEntity);
    }
}
