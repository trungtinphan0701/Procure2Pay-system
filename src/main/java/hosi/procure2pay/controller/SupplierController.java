package hosi.procure2pay.controller;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.request.Supplier.CreateSupplierRequest;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.request.Supplier.UpdateSupplierRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Supplier.CreateSupplierResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.model.response.Supplier.UpdateSupplierResponse;
import hosi.procure2pay.service.Supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/supplier")
@PreAuthorize("hasAnyRole('SUPPLIER_MANAGER','ADMIN')")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/add")
    public Response<CreateSupplierResponse> addSupplier(@RequestBody CreateSupplierRequest supplierEntity) {
        return new Response<>(supplierService.addSupplier(supplierEntity));
    }

    @PostMapping("/add-many")
    public Response<List<CreateSupplierResponse>> addSupplierItemMany(@RequestBody List<CreateSupplierRequest> suppliers) {
        List<CreateSupplierResponse> responses = new ArrayList<>();

        for (CreateSupplierRequest supplier  : suppliers) {
            responses.add(supplierService.addSupplier(supplier));
        }

        return new Response<>(responses);
    }

    @PutMapping("/update")
    public Response<UpdateSupplierResponse> updateSupplier(@RequestBody UpdateSupplierRequest supplierEntity) {
        return new Response<>(supplierService.updateSupplier(supplierEntity));
    }

    @DeleteMapping("/delete/{id}")
    public Response<CreateSupplierResponse> deleteSupplier(@PathVariable Integer id) {
        return new Response<>(supplierService.deleteSupplier(id));
    }

    @GetMapping("/{id}")
    public Response<GetGeneralSupplierInfoResponse> getGeneralSupplierInfo(@PathVariable Integer id) {
        return new Response<>(supplierService.getGeneralSupplierInfo(id));
    }

    @PostMapping("/search")
    public Response<PagedResult<GetGeneralSupplierInfoResponse>> searchSupplier(@RequestBody SearchSupplierRequest request) {
        return new Response<>(supplierService.searchSupplier(request));
    }
}
