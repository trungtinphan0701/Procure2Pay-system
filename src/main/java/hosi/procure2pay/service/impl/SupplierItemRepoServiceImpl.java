package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.SupplierItemRepository;
import hosi.procure2pay.service.repo.SupplierItemRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
