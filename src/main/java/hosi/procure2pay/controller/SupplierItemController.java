package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.response.CreateSupplierItemResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.SupplierItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier-item")
@RequiredArgsConstructor
public class SupplierItemController {
    private final SupplierItemService supplierItemService;

    @PostMapping("/add")
    public Response<CreateSupplierItemResponse> addSupplierItem(@RequestBody CreateSupplierItemRequest request) {
        return new Response<>(supplierItemService.addSupplierItem(request));
    }

    @PostMapping("/add-many")
    public Response<List<CreateSupplierItemResponse>> addSupplierItemMany(@RequestBody List<CreateSupplierItemRequest> supplierItems) {
        List<CreateSupplierItemResponse> responses = new ArrayList<>();

        for (CreateSupplierItemRequest supplierItem  : supplierItems) {
            responses.add(supplierItemService.addSupplierItem(supplierItem));
        }

        return new Response<>(responses);
    }
}
