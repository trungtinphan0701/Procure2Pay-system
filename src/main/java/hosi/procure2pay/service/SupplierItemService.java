package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.response.CreateSupplierItemResponse;

public interface SupplierItemService {
    CreateSupplierItemResponse addSupplierItem(CreateSupplierItemRequest request);
}
