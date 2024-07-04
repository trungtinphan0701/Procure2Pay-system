package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSupplierItemRequest {
    private Integer supplierId;
    private String name;
    private String description;
    private Float unitCost;
}
