package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateRequisitionItemRequest {
    private Integer requisitionId;
    private Integer supplierItemId;
    private Integer quantity;
}
