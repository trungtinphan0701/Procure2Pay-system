package hosi.procure2pay.service;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;

public interface RequisitionService {
    CreateRequisitionResponse createRequisition(CreateRequisitionRequest requisitionRequest);
}
