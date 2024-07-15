package hosi.procure2pay.model.response.Supplier;

import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.model.response.SupplierItem.SupplierItemResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetGeneralSupplierInfoResponse {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private List<SupplierItemResponse> supplierItemEntityList;
}
