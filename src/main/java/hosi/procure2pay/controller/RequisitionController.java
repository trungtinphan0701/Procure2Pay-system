package hosi.procure2pay.controller;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.RequisitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public Response<CreateRequisitionResponse> createRequisition(@RequestBody CreateRequisitionRequest requisitionRequest) {
        return new Response<>(requisitionService.createRequisition(requisitionRequest));
    }
}
