package hosi.procure2pay.model.response.Supplier;

import hosi.procure2pay.entity.SupplierEntity;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetGeneralSupplierInfoResponse {
    private SupplierInfoResponse supplierInfo;
    private List<SupplierItemResponse> supplierItemEntityList;
}
