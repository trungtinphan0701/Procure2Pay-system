package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.response.SupplierItemResponse;

public interface SupplierItemService {
    SupplierItemResponse createSupplierItem(CreateSupplierItemRequest createSupplierItemRequest);
}
