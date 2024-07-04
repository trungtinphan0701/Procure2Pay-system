package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.RequisitionResponse;

public interface RequisitionService {
    RequisitionResponse createRequisition(CreateRequisitionRequest requisitionRequest);
}
