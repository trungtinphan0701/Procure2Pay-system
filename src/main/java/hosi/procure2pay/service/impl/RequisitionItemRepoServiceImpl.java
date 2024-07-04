package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.repository.RequisitionItemRepository;
import hosi.procure2pay.service.RequisitionItemRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisitionItemRepoServiceImpl implements RequisitionItemRepoService {
    private final RequisitionItemRepository requisitionItemRepository;

    @Override
    public RequisitionItemEntity save(RequisitionItemEntity requisitionItemEntity) {
        return requisitionItemRepository.save(requisitionItemEntity);
    }
}
