package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.service.SupplierService;
import hosi.procure2pay.service.repo.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepoService supplierRepoService;

    @Override
    public SupplierEntity addSupplier(SupplierEntity supplierEntity) {
        return supplierRepoService.save(supplierEntity);
    }
}
