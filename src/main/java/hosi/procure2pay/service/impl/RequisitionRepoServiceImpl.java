package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.repository.RequisitionRepository;
import hosi.procure2pay.service.repo.RequisitionRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisitionRepoServiceImpl implements RequisitionRepoService {
    private final RequisitionRepository requisitionRepository;

    @Override
    public RequisitionEntity save(RequisitionEntity requisition) {
        return requisitionRepository.save(requisition);
    }
}
