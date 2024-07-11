package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.request.UpdateRequisitionItemRequest;
import hosi.procure2pay.model.response.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.UpdateRequisitionItemResponse;
import hosi.procure2pay.service.RequisitionItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisition-item")
@PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
@RequiredArgsConstructor
public class RequisitionItemController {
    private final RequisitionItemService requisitionItemService;

    @PostMapping("/add")
    public Response<CreateRequisitionItemResponse> addRequisitionItem(@RequestBody CreateRequisitionItemRequest request) {
        return new Response<>(requisitionItemService.addRequisitionItem(request));
    }

    @PutMapping("/update")
    public Response<UpdateRequisitionItemResponse> updateRequisitionItem(@RequestBody UpdateRequisitionItemRequest request) {
        return new Response<>(requisitionItemService.updateRequisitionItem(request));
    }

    @DeleteMapping("/delete/{id}")
    public Response<CreateRequisitionItemResponse> deleteRequisitionItem(@PathVariable Integer id) {
        return new Response<>(requisitionItemService.deleteRequisitionItem(id));
    }
}
