package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateRequisitionItemRequest {
    private Integer requisitionId;
    private Integer supplierItemId;
    private Integer quantity;
}
