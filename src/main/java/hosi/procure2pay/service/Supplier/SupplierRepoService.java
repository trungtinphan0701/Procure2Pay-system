package hosi.procure2pay.service.Supplier;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import org.springframework.data.domain.Page;

public interface SupplierRepoService {
    SupplierEntity save(SupplierEntity supplier);
    SupplierEntity findById(Integer id);
    void deleteById(Integer id);
    Page<SupplierEntity> search(SearchSupplierRequest request);
}
