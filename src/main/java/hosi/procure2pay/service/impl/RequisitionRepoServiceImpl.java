package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.RequisitionRepository;
import hosi.procure2pay.service.repo.RequisitionRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisitionRepoServiceImpl implements RequisitionRepoService {
    private final RequisitionRepository requisitionRepository;

    @Override
    public RequisitionEntity save(RequisitionEntity requisition) {
        return requisitionRepository.save(requisition);
    }

    @Override
    public RequisitionEntity findById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ID_NULL);
        } else {
            Optional<RequisitionEntity> requisition = requisitionRepository.findById(id);
            if (requisition.isPresent()) {
                return requisition.get();
            } else throw new ResponseException(BadRequestError.REQUISITION_NOT_FOUND);
        }
    }
}
