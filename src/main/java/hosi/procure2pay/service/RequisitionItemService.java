package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.request.UpdateRequisitionItemRequest;
import hosi.procure2pay.model.response.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.UpdateRequisitionItemResponse;

public interface RequisitionItemService {
    CreateRequisitionItemResponse addRequisitionItem(CreateRequisitionItemRequest request);
    UpdateRequisitionItemResponse updateRequisitionItem(UpdateRequisitionItemRequest request);
    CreateRequisitionItemResponse deleteRequisitionItem(Integer id);
}
