package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.request.UpdateSupplierRequest;
import hosi.procure2pay.model.response.CreateSupplierResponse;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.UpdateSupplierResponse;
import hosi.procure2pay.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
}
