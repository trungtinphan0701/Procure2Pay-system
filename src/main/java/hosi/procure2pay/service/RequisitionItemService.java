package hosi.procure2pay.service;


import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.response.RequisitionItemResponse;

public interface RequisitionItemService {
    RequisitionItemResponse createRequisitionItem(CreateRequisitionItemRequest requisitionItemRequest);
}
