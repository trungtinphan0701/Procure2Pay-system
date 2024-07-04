package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.model.response.SupplierResponse;
import hosi.procure2pay.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/create")
    public Response<SupplierResponse> createSupplier(@RequestBody CreateSupplierRequest request) {
        return new Response<>(supplierService.createSupplier(request));
    }
}
