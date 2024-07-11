package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.ApproveRequisitionResponse;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import hosi.procure2pay.model.response.GetRequisitionInfoResponse;

public interface RequisitionService {
    CreateRequisitionResponse addRequisition(CreateRequisitionRequest request);

    GetRequisitionInfoResponse getRequisitionInfoById(Integer id);

    ApproveRequisitionResponse approveRequisition(Integer id);
}