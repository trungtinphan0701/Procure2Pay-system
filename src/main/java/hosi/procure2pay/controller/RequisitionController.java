package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.Requisition.CreateRequisitionRequest;
import hosi.procure2pay.model.request.Requisition.SearchRequisitionRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Requisition.ApproveRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.DeclineRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.GetRequisitionInfoResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.Requisition.RequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController // annotation to start controller
@RequestMapping("/requisition") // annotation to shorten the url
@RequiredArgsConstructor // needed annotation
public class RequisitionController {
    // requisitionService: interface to include all services relevant to requisition
    private final RequisitionService requisitionService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
    // createRequisitionResponse: to get all information that we need without being duplicated
    // @RequestBody: annotation to ???
    // createRequisitionRequest: to get foreign key needed to create new requisition
    public Response<CreateRequisitionResponse> addRequisition(@RequestBody CreateRequisitionRequest request) {
        return new Response<>(requisitionService.addRequisition(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
    public Response<GetRequisitionInfoResponse> getRequisitionInfo(@PathVariable Integer id) {
        return new Response<>(requisitionService.getRequisitionInfoById(id));
    }

    @PutMapping("/approve/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER')")
    public Response<ApproveRequisitionResponse> approveRequisition(@PathVariable Integer id) {
        return new Response<>(requisitionService.approveRequisition(id));
    }

    @PutMapping("/decline/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'APPROVER')")
    public Response<DeclineRequisitionResponse> declineRequisition(@PathVariable Integer id) {
        return new Response<>(requisitionService.declineRequisition(id));
    }

    @PostMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
    public Response<PagedResult<GetRequisitionInfoResponse>> searchRequisition(@RequestBody SearchRequisitionRequest request) {
        return new Response<>(requisitionService.searchRequisition(request));
    }
}
