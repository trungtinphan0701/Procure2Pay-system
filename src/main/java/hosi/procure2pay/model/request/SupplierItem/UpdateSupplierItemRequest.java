package hosi.procure2pay.model.request.SupplierItem;

import hosi.procure2pay.model.enums.SupplierItemState;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateSupplierItemRequest {
    private Integer id;
    private String name;
    private String description;
    private Float unitCost;
    private String type;
    private SupplierItemState supplierItemState;
}
