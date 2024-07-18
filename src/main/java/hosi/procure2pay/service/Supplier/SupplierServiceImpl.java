package hosi.procure2pay.service.Supplier;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.SupplierItemMapper;
import hosi.procure2pay.mapper.SupplierMapper;
import hosi.procure2pay.model.request.Supplier.CreateSupplierRequest;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.request.Supplier.UpdateSupplierRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Supplier.SupplierInfoResponse;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepoService supplierRepoService;
    private final SupplierMapper supplierMapper;
    private final SupplierItemMapper supplierItemMapper;

    // Create new supplier (Supplier Manager and Admin access only)
    @Override
    public SupplierInfoResponse addSupplier(CreateSupplierRequest request) {
        SupplierEntity supplierEntity = new SupplierEntity();
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ResponseException(BadRequestError.MUST_NOT_BE_NULL_OR_EMPTY);
        }
        supplierEntity.setName(request.getName());
        supplierEntity.setAddress(request.getAddress());
        supplierEntity.setPhoneNumber(request.getPhoneNumber());
        supplierRepoService.save(supplierEntity);

        SupplierInfoResponse response = supplierMapper.toCreateSupplierResponse(supplierEntity);
        return response;
    }

    // update supplier details (Supplier Manager and Admin access only)
    @Override
    public SupplierInfoResponse updateSupplier(UpdateSupplierRequest request) {
        SupplierEntity supplierEntity = supplierRepoService.findById(request.getId());
        if (request.getName() != null && !request.getName().isEmpty()) {
            supplierEntity.setName(request.getName());
        }
        if (request.getAddress() != null && !request.getAddress().isEmpty()) {
            supplierEntity.setAddress(request.getAddress());
        }
        if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
            supplierEntity.setPhoneNumber(request.getPhoneNumber());
        }
        supplierRepoService.save(supplierEntity);

        SupplierInfoResponse response = supplierMapper.toCreateSupplierResponse(supplierEntity);
        return response;
    }


    // get supplier info by showing all info related to it
    // including all supplier items related to this supplier id
    @Override
    public GetGeneralSupplierInfoResponse getGeneralSupplierInfo(Integer id) {
        SupplierEntity supplierEntity = supplierRepoService.findById(id);
        GetGeneralSupplierInfoResponse response = new GetGeneralSupplierInfoResponse();
        List<SupplierItemResponse> supplierItemResponseList = new ArrayList<>();

        // for each supplier item in this supplier, get all details
        for (SupplierItemEntity supplierItemEntity : supplierEntity.getSupplierItems()) {
            SupplierItemResponse SupplierItemResponse = supplierItemMapper.toSupplierItemResponse(supplierItemEntity);
            supplierItemResponseList.add(SupplierItemResponse);
        }

        SupplierInfoResponse supplierInfoResponse = supplierMapper.toCreateSupplierResponse(supplierEntity);

        response.setSupplierInfo(supplierInfoResponse);
        response.setSupplierItemEntityList(supplierItemResponseList);

        return response;
    }

    // search function
    @Override
    public PagedResult<GetGeneralSupplierInfoResponse> searchSupplier(SearchSupplierRequest request) {
        Page<SupplierEntity> supplierEntityPage = supplierRepoService.search(request);
        List<SupplierEntity> supplierResponseList = supplierEntityPage.getContent();

        List<GetGeneralSupplierInfoResponse> getGeneralSupplierInfoResponse = new ArrayList<>();

        for (SupplierEntity supplierEntity : supplierResponseList) {
            getGeneralSupplierInfoResponse.add(this.getGeneralSupplierInfo(supplierEntity.getId()));
        }

        return new PagedResult<>(
                getGeneralSupplierInfoResponse,
                supplierEntityPage.getTotalPages(),
                supplierEntityPage.getTotalElements(),
                request.getPageNumber(),
                request.getPageSize());
    }
}
