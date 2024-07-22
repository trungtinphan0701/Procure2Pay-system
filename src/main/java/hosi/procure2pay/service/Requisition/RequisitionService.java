package hosi.procure2pay.service.Requisition;

import hosi.procure2pay.model.request.Requisition.AddRequisitionRequest;
import hosi.procure2pay.model.request.Requisition.SearchRequisitionRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Requisition.ApproveRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.DeclineRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.GetRequisitionInfoResponse;

public interface RequisitionService {
    CreateRequisitionResponse addRequisition(AddRequisitionRequest request);
    GetRequisitionInfoResponse getRequisitionInfoById(Integer id);
    ApproveRequisitionResponse approveRequisition(Integer id);
    DeclineRequisitionResponse declineRequisition(Integer id);
    PagedResult<GetRequisitionInfoResponse> searchRequisition(SearchRequisitionRequest request);
    CreateRequisitionResponse deleteRequisition(Integer id);

}