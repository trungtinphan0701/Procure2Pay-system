package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.RequisitionResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.RequisitionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisition")
@AllArgsConstructor
public class RequisitionController {
    private RequisitionService requisitionService;

    @PostMapping("/create")
    public Response<RequisitionResponse> createRequisition(@RequestBody CreateRequisitionRequest requisitionRequest) {
        return new Response<>(requisitionService.createRequisition(requisitionRequest));
    }
}
