package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.mapper.SupplierMapper;
import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.request.UpdateSupplierRequest;
import hosi.procure2pay.model.response.CreateSupplierResponse;
import hosi.procure2pay.model.response.UpdateSupplierResponse;
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

    @Override
    public UpdateSupplierResponse updateSupplier(UpdateSupplierRequest request) {
        SupplierEntity supplierEntity = supplierRepoService.findById(request.getId());
        if (request.getName() != null) {
            supplierEntity.setName(request.getName());
        }
        if (request.getAddress() != null) {
            supplierEntity.setAddress(request.getAddress());
        }
        if (request.getPhoneNumber() != null) {
            supplierEntity.setPhoneNumber(request.getPhoneNumber());
        }
        supplierRepoService.save(supplierEntity);
        UpdateSupplierResponse response = supplierMapper.toUpdateSupplierResponse(supplierEntity);
        return response;
    }

    @Override
    public CreateSupplierResponse deleteSupplier(Integer id) {
        SupplierEntity supplierEntity = supplierRepoService.findById(id);
        supplierRepoService.deleteById(id);
        return supplierMapper.toCreateSupplierResponse(supplierEntity);
    }
}
