package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import hosi.procure2pay.model.response.GetRequisitionInfoResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.RequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // annotation to start controller
@RequestMapping("/requisition") // annotation to shorten the url
@RequiredArgsConstructor // needed annotation
public class RequisitionController {
    // requisitionService: interface to include all services relevant to requisition
    private final RequisitionService requisitionService;

    @PostMapping("/add")
    // createRequisitionResponse: to get all information that we need without being duplicated
    // @RequestBody: annotation to ???
    // createRequisitionRequest: to get foreign key needed to create new requisition
    public Response<CreateRequisitionResponse> addRequisition(@RequestBody CreateRequisitionRequest requisition) {
        return new Response<>(requisitionService.addRequisition(requisition));
    }

    @GetMapping("/{id}")
    public Response<GetRequisitionInfoResponse> getRequisitionInfo(@PathVariable Integer id) {
        return new Response<>(requisitionService.getRequisitionInfoById(id));
    }
}
