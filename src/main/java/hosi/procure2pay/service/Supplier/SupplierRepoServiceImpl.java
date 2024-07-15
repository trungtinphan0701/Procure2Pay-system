package hosi.procure2pay.service.Supplier;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import hosi.procure2pay.entity.QSupplierEntity;
import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierRepoServiceImpl implements SupplierRepoService {
    private final SupplierRepository supplierRepository;

    @Override
    public SupplierEntity save(SupplierEntity supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public SupplierEntity findById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
        } else {
            Optional<SupplierEntity> supplier = supplierRepository.findById(id);
            if (supplier.isPresent()) {
                return supplier.get();
            } else throw new ResponseException(BadRequestError.SUPPLIER_NOT_FOUND);
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
        }
        supplierRepository.deleteById(id);
    }

    private Predicate buildPredicateSearchSupplier(SearchSupplierRequest request) {
        BooleanBuilder builder = new BooleanBuilder();

        if (request.getSupplierName() != null && !request.getSupplierName().isEmpty()) {
            builder.and(QSupplierEntity.supplierEntity.name.like("%" + request.getSupplierName() + "%"));
        }

        if (request.getAddress() != null && !request.getAddress().isEmpty()) {
            builder.and(QSupplierEntity.supplierEntity.address.like("%" + request.getAddress() + "%"));
        }

        return builder;
    }

    @Override
    public Page<SupplierEntity> search(SearchSupplierRequest request) {
        Predicate predicate = buildPredicateSearchSupplier(request);

        Sort sort = Sort.by(List.of(
                new Sort.Order(Sort.Direction.ASC, "name")
        ));

        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize(), sort);

        return supplierRepository.findAll(predicate, pageRequest);
    }


}
