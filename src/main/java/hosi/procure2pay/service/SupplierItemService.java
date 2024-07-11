package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.request.SearchSupplierItemRequest;
import hosi.procure2pay.model.response.SupplierItemResponse;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.SupplierItemResponse;

public interface SupplierItemService {
    SupplierItemResponse addSupplierItem(CreateSupplierItemRequest request);

    PagedResult<SupplierItemResponse> searchSupplierItems(SearchSupplierItemRequest request);
}
