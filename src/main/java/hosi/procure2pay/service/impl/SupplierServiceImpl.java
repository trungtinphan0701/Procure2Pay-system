package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.SupplierMapper;
import hosi.procure2pay.model.request.CreateSupplierRequest;
import hosi.procure2pay.model.response.SupplierResponse;
import hosi.procure2pay.service.SupplierRepoService;
import hosi.procure2pay.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepoService supplierRepoService;
    private final SupplierMapper supplierMapper;

    @Override
    public SupplierResponse createSupplier(CreateSupplierRequest request) {
        this.handleSupplierRequest(request);

        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setName(request.getName());
        supplierEntity.setAddress(request.getAddress());
        supplierEntity.setPhoneNumber(request.getPhoneNumber());

        supplierEntity = supplierRepoService.save(supplierEntity);

        return supplierMapper.toResponse(supplierEntity);
    }

    private void handleSupplierRequest(CreateSupplierRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ResponseException(BadRequestError.SUPPLIER_NAME_INVALID);
        }

        if (request.getAddress() == null || request.getAddress().isEmpty()) {
            throw new ResponseException(BadRequestError.SUPPLIER_ADDRESS_INVALID);
        }

        if (request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty()) {
            throw new ResponseException(BadRequestError.SUPPLIER_PHONE_NUMBER_INVALID);
        }
    }
}
