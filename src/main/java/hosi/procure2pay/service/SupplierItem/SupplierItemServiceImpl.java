package hosi.procure2pay.service.SupplierItem;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.SupplierItemMapper;
import hosi.procure2pay.model.enums.SupplierItemState;
import hosi.procure2pay.model.request.SupplierItem.CreateSupplierItemRequest;
import hosi.procure2pay.model.request.SupplierItem.SearchSupplierItemRequest;
import hosi.procure2pay.model.request.SupplierItem.UpdateSupplierItemRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import hosi.procure2pay.model.response.SupplierItem.UpdateSupplierItemResponse;
import hosi.procure2pay.service.Supplier.SupplierRepoService;
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

    // create supplier item (Supplier Manager and Admin access only)
    @Override
    public SupplierItemResponse addSupplierItem(CreateSupplierItemRequest request) {
        this.handleCreateSupplierItemRequest(request);
        SupplierEntity supplier = supplierRepoService.findById(request.getSupplierId());

        SupplierItemEntity supplierItem = new SupplierItemEntity();
        supplierItem.setSupplier(supplier);
        // new supplier item should be in stock all the time
        supplierItem.setState(SupplierItemState.IN_STOCK);
        supplierItem.setName(request.getItemName());
        supplierItem.setDescription(request.getItemDescription());
        supplierItem.setUnitCost(request.getUnitCost());
        supplierItem.setType(request.getType());
        supplierItemRepoService.save(supplierItem);

        SupplierItemResponse response = supplierItemMapper.toSupplierItemResponse(supplierItem);
        return response;
    }

    // update supplier item details (can update anything)
    @Override
    public UpdateSupplierItemResponse updateSupplierItem(UpdateSupplierItemRequest request) {
        SupplierItemEntity supplierItemEntity = supplierItemRepoService.findById(request.getId());
        if (request.getName() != null && !request.getName().isEmpty()) {
            supplierItemEntity.setName(request.getName());
        }
        if (request.getDescription() != null && !request.getDescription().isEmpty()) {
            supplierItemEntity.setDescription(request.getDescription());
        }
        if (request.getUnitCost() != null) {
            supplierItemEntity.setUnitCost(request.getUnitCost());
        }
        if (request.getType() != null && !request.getType().isEmpty()) {
            supplierItemEntity.setType(request.getType());
        }
        if (request.getSupplierItemState() != null) {
            supplierItemEntity.setState(request.getSupplierItemState());
        }
        supplierItemRepoService.save(supplierItemEntity);
        return supplierItemMapper.toUpdateSupplierItemResponse(supplierItemEntity);
    }

    // search function
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


    // get supplier item by id
    @Override
    public SupplierItemResponse getSupplierItem(Integer id) {
        SupplierItemEntity supplierItemEntity = supplierItemRepoService.findById(id);
        return supplierItemMapper.toSupplierItemResponse(supplierItemEntity);
    }


    private void handleSearchSupplierItemRequest(SearchSupplierItemRequest request) {
        if (request.getMinUnitCost() > request.getMaxUnitCost()) {
            throw new ResponseException(BadRequestError.MIN_MUST_BE_SMALLER_THAN_MAX);
        }
    }

    private void handleCreateSupplierItemRequest(CreateSupplierItemRequest request) {
        if (request.getSupplierId() == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ID_NULL);
        }

        if (request.getItemName() == null || request.getItemName().isEmpty()
        || request.getUnitCost() == null) {
            throw new ResponseException(BadRequestError.MUST_NOT_BE_NULL_OR_EMPTY);
        }
    }
}
