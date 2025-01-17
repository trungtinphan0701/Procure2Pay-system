package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.RequisitionItem.CreateRequisitionItemRequest;
import hosi.procure2pay.model.request.RequisitionItem.UpdateRequisitionItemRequest;
import hosi.procure2pay.model.response.RequisitionItem.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.RequisitionItem.UpdateRequisitionItemResponse;
import hosi.procure2pay.service.RequisitionItem.RequisitionItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/requisition-item")
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
