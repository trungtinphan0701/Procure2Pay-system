package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.SupplierItemMapper;
import hosi.procure2pay.model.enums.ItemAvailability;
import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.response.SupplierItemResponse;
import hosi.procure2pay.service.SupplierItemRepoService;
import hosi.procure2pay.service.SupplierItemService;
import hosi.procure2pay.service.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierItemServiceImpl implements SupplierItemService {
    private final SupplierRepoService supplierRepoService;
    private final SupplierItemRepoService supplierItemRepoService;
    private final SupplierItemMapper supplierItemMapper;
    @Override
    public SupplierItemResponse createSupplierItem(CreateSupplierItemRequest createSupplierItemRequest) {
        this.handleSupplierItemRequest(createSupplierItemRequest);

        SupplierEntity supplierEntity = supplierRepoService.findById(createSupplierItemRequest.getSupplierId());

        SupplierItemEntity supplierItemEntity = new SupplierItemEntity();
        supplierItemEntity.setSupplier(supplierEntity);
        supplierItemEntity.setName(createSupplierItemRequest.getName());
        supplierItemEntity.setUnitCost(createSupplierItemRequest.getUnitCost());
        supplierItemEntity.setDescription(createSupplierItemRequest.getDescription());
        supplierItemEntity.setAvailability(ItemAvailability.IN_STOCK);

        supplierItemEntity = supplierItemRepoService.save(supplierItemEntity);

        return supplierItemMapper.toResponse(supplierItemEntity);
    }

    private void handleSupplierItemRequest(CreateSupplierItemRequest createSupplierItemRequest) {
        if (createSupplierItemRequest.getSupplierId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_INVALID);
        }

        if (createSupplierItemRequest.getName() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_NAME_INVALID);
        }

        if (createSupplierItemRequest.getUnitCost() == null) {
            throw new ResponseException(BadRequestError.PRICE_INVALID);
        }
    }
}
