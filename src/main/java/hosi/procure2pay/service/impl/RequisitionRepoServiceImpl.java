package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.RequisitionRepository;
import hosi.procure2pay.service.RequisitionRepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RequisitionRepoServiceImpl implements RequisitionRepoService {
    private RequisitionRepository requisitionRepository;
    @Override
    public RequisitionEntity save(RequisitionEntity requisitionEntity) {
        return requisitionRepository.save(requisitionEntity);
    }

    @Override
    public RequisitionEntity findById(Integer requisitionId) {
        if (requisitionId == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ID_INVALID);
        }

        Optional<RequisitionEntity> requisitionEntity = requisitionRepository.findById(requisitionId);

        if (requisitionEntity.isEmpty()) {
            throw new ResponseException(BadRequestError.REQUISITION_NOT_FOUND);
        }

        return requisitionEntity.get();
    }
}
