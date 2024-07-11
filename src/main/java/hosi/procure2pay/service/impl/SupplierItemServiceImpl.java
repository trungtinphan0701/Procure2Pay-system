package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.SupplierItemMapper;
import hosi.procure2pay.model.enums.SupplierItemState;
import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.request.SearchSupplierItemRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.SupplierItemResponse;
import hosi.procure2pay.service.SupplierItemService;
import hosi.procure2pay.service.repo.SupplierItemRepoService;
import hosi.procure2pay.service.repo.SupplierRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierItemServiceImpl implements SupplierItemService {
    private final SupplierRepoService supplierRepoService;
    private final SupplierItemRepoService supplierItemRepoService;
    private final SupplierItemMapper supplierItemMapper;

    @Override
    public SupplierItemResponse addSupplierItem(CreateSupplierItemRequest request) {
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

        SupplierItemResponse response = supplierItemMapper.toSupplierItemResponse(supplierItem);
        return response;
    }

    @Override
    public PagedResult<SupplierItemResponse> searchSupplierItems(SearchSupplierItemRequest request) {
        this.handleSearchSupplierItemRequest(request);
        Page<SupplierItemEntity> supplierItemEntityPage = supplierItemRepoService.searchSupplierItem(request);
        List<SupplierItemResponse> supplierItemResponseList = supplierItemMapper.toSupplierItemResponseList(supplierItemEntityPage.getContent());

        return new PagedResult<>(
                supplierItemResponseList,
                supplierItemEntityPage.getTotalPages(),
                supplierItemEntityPage.getTotalElements(),
                request.getPageNumber(),
                request.getPageSize());
    }

    private void handleSearchSupplierItemRequest(SearchSupplierItemRequest request) {
//        if (request.getSupplierName() == null || request.getSupplierName().isEmpty()) {
//            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_ID_NULL);
//        }
        if (request.getMinUnitCost() > request.getMaxUnitCost()) {
            throw new ResponseException(BadRequestError.MIN_MUST_BE_SMALLER_THAN_MAX);
        }
    }
}
