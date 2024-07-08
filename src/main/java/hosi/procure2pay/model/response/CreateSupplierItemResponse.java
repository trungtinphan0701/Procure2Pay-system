package hosi.procure2pay.model.response;

import lombok.Data;

@Data
public class CreateSupplierItemResponse {
    private Integer supplierItemId;
    private String supplierName;
    private String description;
    private Float unitCost;
    private String type;
    private String state;
}
