package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.repository.SupplierItemRepository;
import hosi.procure2pay.service.SupplierItemRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierItemRepoServiceImpl implements SupplierItemRepoService {
    private final SupplierItemRepository supplierItemRepository;
    @Override
    public SupplierItemEntity save(SupplierItemEntity supplierItemEntity) {
        return supplierItemRepository.save(supplierItemEntity);
    }
}
