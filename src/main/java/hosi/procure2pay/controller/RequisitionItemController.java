package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateRequisitionItemRequest;
import hosi.procure2pay.model.response.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.RequisitionItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisition-item")
@RequiredArgsConstructor
public class RequisitionItemController {
    private final RequisitionItemService requisitionItemService;

    @PostMapping("/add")
    public Response<CreateRequisitionItemResponse> addRequisitionItem(@RequestBody CreateRequisitionItemRequest request) {
        return new Response<>(requisitionItemService.addRequisitionItem(request));
    }
}
