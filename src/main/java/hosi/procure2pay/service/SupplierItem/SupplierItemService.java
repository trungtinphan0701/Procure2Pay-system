package hosi.procure2pay.service.SupplierItem;

import hosi.procure2pay.model.request.SupplierItem.CreateSupplierItemRequest;
import hosi.procure2pay.model.request.SupplierItem.SearchSupplierItemRequest;
import hosi.procure2pay.model.request.SupplierItem.UpdateSupplierItemRequest;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.SupplierItem.UpdateSupplierItemResponse;

public interface SupplierItemService {
    SupplierItemResponse addSupplierItem(CreateSupplierItemRequest request);
    UpdateSupplierItemResponse updateSupplierItem(UpdateSupplierItemRequest request);
    PagedResult<SupplierItemResponse> searchSupplierItems(SearchSupplierItemRequest request);
    SupplierItemResponse deleteSupplierItem(Integer id);
}
