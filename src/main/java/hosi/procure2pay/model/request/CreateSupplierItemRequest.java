package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateSupplierItemRequest {
    private Integer supplierId;
    private String itemName;
    private String itemDescription;
    private Float unitCost;
    private String type;

}
