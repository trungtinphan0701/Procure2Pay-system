package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.response.CreateSupplierResponse;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier")
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
}
