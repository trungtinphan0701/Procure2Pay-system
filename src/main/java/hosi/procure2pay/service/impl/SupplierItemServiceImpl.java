package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.SupplierItemMapper;
import hosi.procure2pay.model.enums.SupplierItemState;
import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.response.CreateSupplierItemResponse;
import hosi.procure2pay.service.SupplierItemService;
import hosi.procure2pay.service.repo.SupplierItemRepoService;
import hosi.procure2pay.service.repo.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierItemServiceImpl implements SupplierItemService {
    private final SupplierRepoService supplierRepoService;
    private final SupplierItemRepoService supplierItemRepoService;
    private final SupplierItemMapper supplierItemMapper;

    @Override
    public CreateSupplierItemResponse addSupplierItem(CreateSupplierItemRequest request) {
        if (request.getSupplierId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
        }
        SupplierEntity supplier = supplierRepoService.findById(request.getSupplierId());

        SupplierItemEntity supplierItem = new SupplierItemEntity();
        supplierItem.setSupplier(supplier);
        supplierItem.setState(SupplierItemState.IN_STOCK);
        supplierItem.setName(request.getItemName());
        supplierItem.setDescription(request.getItemDescription());
        supplierItem.setUnitCost(request.getUnitCost());
        supplierItem.setType(request.getType());
        supplierItemRepoService.save(supplierItem);

        CreateSupplierItemResponse response = supplierItemMapper.toSupplierItemResponse(supplierItem);
        return response;
    }
}
