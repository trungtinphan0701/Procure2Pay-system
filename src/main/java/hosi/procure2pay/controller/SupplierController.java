package hosi.procure2pay.controller;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<SupplierEntity> addSupplier(@RequestBody SupplierEntity supplierEntity) {
        return ResponseEntity.ok(supplierService.addSupplier(supplierEntity));
    }
}
