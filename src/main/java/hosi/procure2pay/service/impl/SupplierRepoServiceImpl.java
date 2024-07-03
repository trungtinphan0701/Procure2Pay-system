package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.SupplierRepository;
import hosi.procure2pay.service.repo.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


}
