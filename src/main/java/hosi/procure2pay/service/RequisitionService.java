package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;

public interface RequisitionService {
    CreateRequisitionResponse addRequisition(CreateRequisitionRequest request);
}
