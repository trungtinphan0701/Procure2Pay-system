package hosi.procure2pay.service.Requisition;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import hosi.procure2pay.entity.QRequisitionEntity;
import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.Requisition.SearchRequisitionRequest;
import hosi.procure2pay.repository.RequisitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisitionRepoServiceImpl implements RequisitionRepoService {
    private final RequisitionRepository requisitionRepository;

    // save requisition to database
    @Override
    public RequisitionEntity save(RequisitionEntity requisition) {
        return requisitionRepository.save(requisition);
    }

    // find requisition by id
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

    // search function
    @Override
    public Page<RequisitionEntity> searchRequisition(SearchRequisitionRequest request) {
        Predicate predicate = buildPredicateSearchRequisition(request);

        Sort sort = Sort.by(List.of(
                new Sort.Order(Sort.Direction.ASC, "id")
        ));

        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize(), sort);

        Page<RequisitionEntity> result = requisitionRepository.findAll(predicate, pageRequest);

        return result;
    }

    private Predicate buildPredicateSearchRequisition(SearchRequisitionRequest request) {
        BooleanBuilder builder = new BooleanBuilder();

        if (request.getCode() != null && !request.getCode().isEmpty()) {
            builder.and(QRequisitionEntity.requisitionEntity.code.like("%" + request.getCode() + "%"));
        }

        if (request.getState()!= null) {
            builder.and(QRequisitionEntity.requisitionEntity.state.eq(request.getState()));
        }

        if (request.getSupplierItem() != null) {
            builder.and(QRequisitionEntity.requisitionEntity.requisitionItemEntityList.any().supplierItem.name
                    .like("%" + request.getSupplierItem() + "%"));
        }

        if (request.getMinTotalCost() != null) {
            builder.and(QRequisitionEntity.requisitionEntity.totalCost.goe(request.getMinTotalCost()));
        }

        if (request.getMaxTotalCost() != null) {
            builder.and(QRequisitionEntity.requisitionEntity.totalCost.loe(request.getMaxTotalCost()));
        }

        if (request.getFromDate() != null) {
            builder.and(QRequisitionEntity.requisitionEntity.createdOn.after(LocalDate.parse(request.getFromDate()).atStartOfDay()));
        }

        if (request.getToDate() != null) {
            builder.and(QRequisitionEntity.requisitionEntity.createdOn.before(LocalDate.parse(request.getToDate()).atTime(23,59,59)));
        }

        return builder;
    }
}
