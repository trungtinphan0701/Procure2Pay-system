package hosi.procure2pay.service.repo;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.model.request.SearchSupplierItemRequest;
import org.springframework.data.domain.Page;

public interface SupplierItemRepoService {
    SupplierItemEntity save(SupplierItemEntity supplierItem);

    SupplierItemEntity findById(Integer id);

    Page<SupplierItemEntity> searchSupplierItem(SearchSupplierItemRequest request);
}
