package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.mapper.SupplierMapper;
import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.response.CreateSupplierResponse;
import hosi.procure2pay.service.SupplierService;
import hosi.procure2pay.service.repo.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepoService supplierRepoService;
    private final SupplierMapper supplierMapper;

    @Override
    public CreateSupplierResponse addSupplier(CreateSupplierRequest request) {
        SupplierEntity supplierEntity = new SupplierEntity();

        supplierEntity.setName(request.getName());
        supplierEntity.setAddress(request.getAddress());
        supplierEntity.setPhoneNumber(request.getPhoneNumber());
        supplierRepoService.save(supplierEntity);

        CreateSupplierResponse response = supplierMapper.toCreateSupplierResponse(supplierEntity);
        return response;
    }
}
