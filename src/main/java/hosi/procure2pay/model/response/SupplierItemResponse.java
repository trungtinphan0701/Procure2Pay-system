package hosi.procure2pay.model.response;

import lombok.Data;

@Data
public class SupplierItemResponse {
    private Integer supplierItemId;
    private String supplierItemName;
    private String supplierName;
    private String description;
    private Float unitCost;
    private String type;
    private String state;
}
