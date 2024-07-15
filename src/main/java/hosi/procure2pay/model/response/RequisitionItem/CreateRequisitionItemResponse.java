package hosi.procure2pay.model.response.RequisitionItem;

import lombok.Data;

@Data
public class CreateRequisitionItemResponse {
    private Integer requisitionItemId;
    private Integer requisitionId;
    private String supplierName;
    private Integer quantity;
    private Float unitCost;
    private Float totalCost;
}


