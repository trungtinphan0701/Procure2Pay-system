package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.Supplier.CreateSupplierRequest;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.request.Supplier.UpdateSupplierRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Supplier.SupplierInfoResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.service.Supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN')")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN')")
    public Response<SupplierInfoResponse> addSupplier(@RequestBody CreateSupplierRequest supplierEntity) {
        return new Response<>(supplierService.addSupplier(supplierEntity));
    }

    @PostMapping("/add-many")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN')")
    public Response<List<SupplierInfoResponse>> addSupplierItemMany(@RequestBody List<CreateSupplierRequest> suppliers) {
        List<SupplierInfoResponse> responses = new ArrayList<>();

        for (CreateSupplierRequest supplier  : suppliers) {
            responses.add(supplierService.addSupplier(supplier));
        }

        return new Response<>(responses);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN')")
    public Response<SupplierInfoResponse> updateSupplier(@RequestBody UpdateSupplierRequest supplierEntity) {
        return new Response<>(supplierService.updateSupplier(supplierEntity));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN','APPROVER','PURCHASER')")
    public Response<GetGeneralSupplierInfoResponse> getGeneralSupplierInfo(@PathVariable Integer id) {
        return new Response<>(supplierService.getGeneralSupplierInfo(id));
    }

    @PostMapping("/search")
    @PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN','APPROVER','PURCHASER')")
    public Response<PagedResult<GetGeneralSupplierInfoResponse>> searchSupplier(@RequestBody SearchSupplierRequest request) {
        return new Response<>(supplierService.searchSupplier(request));
    }
}
