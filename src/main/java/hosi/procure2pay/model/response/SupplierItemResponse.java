package hosi.procure2pay.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierItemResponse {
    private Integer id;
    private String supplierName;
    private String supplierItemName;
    private String description;
    private Float unitCost;
    private String availability;
}
