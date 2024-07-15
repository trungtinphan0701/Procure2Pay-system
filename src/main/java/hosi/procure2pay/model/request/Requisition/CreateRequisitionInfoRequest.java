package hosi.procure2pay.model.request.Requisition;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CreateRequisitionInfoRequest {
    private Integer supplierId;
    private List<RequisitionItemRequest> requisitionItemRequestList;
}

class RequisitionItemRequest {
    private Integer supplierItemId;
    private Integer quantity;
}
