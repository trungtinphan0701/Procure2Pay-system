package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.RequisitionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisition")
@RequiredArgsConstructor
public class RequisitionController {
    private final RequisitionService requisitionService;

    @PostMapping("/add")
    public Response<CreateRequisitionResponse> addRequisition(@RequestBody CreateRequisitionRequest requisition) {
        return new Response<>(requisitionService.addRequisition(requisition));
    }
}
