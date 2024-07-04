package hosi.procure2pay.model.response;

import hosi.procure2pay.model.enums.SupplierItemState;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
