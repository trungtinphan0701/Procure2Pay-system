package hosi.procure2pay.model.response.RequisitionItem;

import lombok.Data;

@Data
public class UpdateRequisitionItemResponse {
    private Integer requisitionId;
    private Integer supplierItemId;
    private Integer quantity;
    private Float totalCost;
}