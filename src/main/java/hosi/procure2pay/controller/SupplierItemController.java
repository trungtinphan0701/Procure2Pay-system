package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.SupplierItem.CreateSupplierItemRequest;
import hosi.procure2pay.model.request.SupplierItem.SearchSupplierItemRequest;
import hosi.procure2pay.model.request.SupplierItem.UpdateSupplierItemRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.SupplierItem.UpdateSupplierItemResponse;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.service.SupplierItem.SupplierItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier-item")
@RequiredArgsConstructor
public class SupplierItemController {
    private final SupplierItemService supplierItemService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('SUPPLIER_MANAGER')")
    public Response<SupplierItemResponse> addSupplierItem(@RequestBody CreateSupplierItemRequest request) {
        return new Response<>(supplierItemService.addSupplierItem(request));
    }

    @PostMapping("/add-many")
    @PreAuthorize("hasRole('SUPPLIER_MANAGER')")
    public Response<List<SupplierItemResponse>> addSupplierItemMany(@RequestBody List<CreateSupplierItemRequest> supplierItems) {
        List<SupplierItemResponse> responses = new ArrayList<>();

        for (CreateSupplierItemRequest supplierItem  : supplierItems) {
            responses.add(supplierItemService.addSupplierItem(supplierItem));
        }

        return new Response<>(responses);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN','APPROVER','PURCHASER')")
    public Response<SupplierItemResponse> getSupplierItem(@PathVariable Integer id) {
        return new Response<>(supplierItemService.getSupplierItem(id));
    }

    @PostMapping("/search")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN','APPROVER','PURCHASER')")
    public Response<PagedResult<SupplierItemResponse>> searchSupplierItem(@RequestBody SearchSupplierItemRequest request) {
        return new Response<>(supplierItemService.searchSupplierItems(request));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('SUPPLIER_MANAGER')")
    public Response<UpdateSupplierItemResponse> updateSupplierItem(@RequestBody UpdateSupplierItemRequest request) {
        return new Response<>(supplierItemService.updateSupplierItem(request));
    }
}
