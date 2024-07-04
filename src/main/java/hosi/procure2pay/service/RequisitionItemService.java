package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.response.CreateRequisitionItemResponse;

public interface RequisitionItemService {
    CreateRequisitionItemResponse addRequisitionItem(CreateRequisitionItemRequest request);
}
