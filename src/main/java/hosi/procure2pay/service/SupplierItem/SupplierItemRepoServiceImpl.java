package hosi.procure2pay.service.SupplierItem;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import hosi.procure2pay.entity.QSupplierItemEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.SupplierItem.SearchSupplierItemRequest;
import hosi.procure2pay.repository.SupplierItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierItemRepoServiceImpl implements SupplierItemRepoService {
    private final SupplierItemRepository supplierItemRepository;

    @Override
    public SupplierItemEntity save(SupplierItemEntity supplierItem) {
        return supplierItemRepository.save(supplierItem);
    }

    @Override
    public SupplierItemEntity findById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_ID_NULL);
        } else {
            Optional<SupplierItemEntity> supplierItem = supplierItemRepository.findById(id);
            if (supplierItem.isPresent()) {
                return supplierItem.get();
            } else throw new ResponseException(BadRequestError.SUPPLIER_ITEM_NOT_FOUND);
        }
    }

    @Override
    public Page<SupplierItemEntity> searchSupplierItem(SearchSupplierItemRequest request) {
        Predicate predicate = buildPredicateSearchSupplierItem(request);

        // Default sort direction
        Sort sort = Sort.by(List.of(
                new Sort.Order(Sort.Direction.ASC, "unitCost")
        ));

        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize(), sort);

        return supplierItemRepository.findAll(predicate, pageRequest);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_ID_NULL);
        }
        supplierItemRepository.deleteById(id);
    }

    private Predicate buildPredicateSearchSupplierItem(SearchSupplierItemRequest request) {
        BooleanBuilder builder = new BooleanBuilder();

        if (request.getSupplierName() != null && !request.getSupplierName().isEmpty()) {
            builder.and(QSupplierItemEntity.supplierItemEntity.name.like("%" + request.getSupplierName() + "%"));
        }

        if (request.getMinUnitCost() != null) {
            builder.and(QSupplierItemEntity.supplierItemEntity.unitCost.goe(request.getMinUnitCost()));
        }

        if (request.getMaxUnitCost() != null) {
            builder.and(QSupplierItemEntity.supplierItemEntity.unitCost.loe(request.getMaxUnitCost()));
        }

        return builder;
    }
}
