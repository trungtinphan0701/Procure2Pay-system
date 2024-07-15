package hosi.procure2pay.service.Requisition;

import hosi.procure2pay.model.request.Requisition.CreateRequisitionRequest;
import hosi.procure2pay.model.response.Requisition.ApproveRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.GetRequisitionInfoResponse;

public interface RequisitionService {
    CreateRequisitionResponse addRequisition(CreateRequisitionRequest request);

    GetRequisitionInfoResponse getRequisitionInfoById(Integer id);

    ApproveRequisitionResponse approveRequisition(Integer id);

//    GetRequisitionInfoResponse createRequisition(CreateRequisitionInfoRequest request);
}