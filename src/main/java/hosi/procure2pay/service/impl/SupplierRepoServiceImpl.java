package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.SupplierRepository;
import hosi.procure2pay.service.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierRepoServiceImpl implements SupplierRepoService {
    private final SupplierRepository supplierRepository;
    @Override
    public SupplierEntity save(SupplierEntity supplierEntity) {
        return supplierRepository.save(supplierEntity);
    }

    @Override
    public SupplierEntity findById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_INVALID);
        }

        Optional<SupplierEntity> supplierEntity = supplierRepository.findById(id);
        if (supplierEntity.isEmpty()) {
            throw new ResponseException(BadRequestError.SUPPLIER_NOT_FOUND);
        }

        return supplierEntity.get();
    }
}
