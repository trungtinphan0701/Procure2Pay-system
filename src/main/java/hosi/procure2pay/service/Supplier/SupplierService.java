package hosi.procure2pay.service.Supplier;


import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.request.Supplier.CreateSupplierRequest;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.request.Supplier.UpdateSupplierRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Supplier.CreateSupplierResponse;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;
import hosi.procure2pay.model.response.Supplier.UpdateSupplierResponse;

public interface SupplierService {
    CreateSupplierResponse addSupplier(CreateSupplierRequest request);
    UpdateSupplierResponse updateSupplier(UpdateSupplierRequest request);
    CreateSupplierResponse deleteSupplier(Integer id);
    GetGeneralSupplierInfoResponse getGeneralSupplierInfo(Integer id);
    PagedResult<GetGeneralSupplierInfoResponse> searchSupplier(SearchSupplierRequest request);
}
