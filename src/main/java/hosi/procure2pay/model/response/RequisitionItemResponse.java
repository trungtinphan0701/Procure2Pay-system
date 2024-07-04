package hosi.procure2pay.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequisitionItemResponse {
    private String supplierName;
    private String itemName;
    private String itemDescription;
    private Integer quantity;
    private Float unitPrice;
    private Float totalPrice;
}
