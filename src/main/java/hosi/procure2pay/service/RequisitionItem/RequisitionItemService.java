package hosi.procure2pay.service.RequisitionItem;

import hosi.procure2pay.model.request.RequisitionItem.CreateRequisitionItemRequest;
import hosi.procure2pay.model.request.RequisitionItem.UpdateRequisitionItemRequest;
import hosi.procure2pay.model.response.RequisitionItem.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.RequisitionItem.UpdateRequisitionItemResponse;

public interface RequisitionItemService {
    CreateRequisitionItemResponse addRequisitionItem(CreateRequisitionItemRequest request);
    UpdateRequisitionItemResponse updateRequisitionItem(UpdateRequisitionItemRequest request);
    CreateRequisitionItemResponse deleteRequisitionItem(Integer id);
}
