package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.SupplierItemResponse;
import hosi.procure2pay.service.SupplierItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier-item")
@RequiredArgsConstructor
public class SupplierItemController {
    private final SupplierItemService supplierItemService;

    @PostMapping("/create")
    public Response<SupplierItemResponse> createSupplierItem(@RequestBody CreateSupplierItemRequest createSupplierItemRequest) {
        return new Response<> (supplierItemService.createSupplierItem(createSupplierItemRequest));
    }
}
