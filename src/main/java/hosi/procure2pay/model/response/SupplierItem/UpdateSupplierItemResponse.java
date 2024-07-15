package hosi.procure2pay.model.response.SupplierItem;

import hosi.procure2pay.model.enums.SupplierItemState;
import lombok.Data;

@Data
public class UpdateSupplierItemResponse {
    private String name;
    private String description;
    private Float unitCost;
    private String type;
    private SupplierItemState supplierItemState;
}
