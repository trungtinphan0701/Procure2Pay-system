package hosi.procure2pay.service.Supplier;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.mapper.SupplierItemMapper;
import hosi.procure2pay.mapper.SupplierMapper;
import hosi.procure2pay.model.request.Supplier.CreateSupplierRequest;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.request.Supplier.UpdateSupplierRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Supplier.CreateSupplierResponse;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.model.response.Supplier.UpdateSupplierResponse;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import hosi.procure2pay.service.SupplierItem.SupplierItemService;
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

    @Override
    public GetGeneralSupplierInfoResponse getGeneralSupplierInfo(Integer id) {
        SupplierEntity supplierEntity = supplierRepoService.findById(id);
        GetGeneralSupplierInfoResponse response = new GetGeneralSupplierInfoResponse();
        List<SupplierItemResponse> supplierItemResponseList = new ArrayList<>();

        for (SupplierItemEntity supplierItemEntity : supplierEntity.getSupplierItems()) {
            SupplierItemResponse SupplierItemResponse = supplierItemMapper.toSupplierItemResponse(supplierItemEntity);
            supplierItemResponseList.add(SupplierItemResponse);
        }

        response.setId(id);
        response.setAddress(supplierEntity.getAddress());
        response.setName(supplierEntity.getName());
        response.setPhone(supplierEntity.getPhoneNumber());
        response.setSupplierItemEntityList(supplierItemResponseList);

        return response;
    }

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
