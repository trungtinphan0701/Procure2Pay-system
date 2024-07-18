package hosi.procure2pay.service.Supplier;


import hosi.procure2pay.model.request.Supplier.CreateSupplierRequest;
import hosi.procure2pay.model.request.Supplier.SearchSupplierRequest;
import hosi.procure2pay.model.request.Supplier.UpdateSupplierRequest;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.Supplier.SupplierInfoResponse;
import hosi.procure2pay.model.response.Supplier.GetGeneralSupplierInfoResponse;

public interface SupplierService {
    SupplierInfoResponse addSupplier(CreateSupplierRequest request);
    SupplierInfoResponse updateSupplier(UpdateSupplierRequest request);
    GetGeneralSupplierInfoResponse getGeneralSupplierInfo(Integer id);
    PagedResult<GetGeneralSupplierInfoResponse> searchSupplier(SearchSupplierRequest request);
}
