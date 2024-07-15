package hosi.procure2pay.model.request.Requisition;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
// User input
public class CreateRequisitionRequest {
    private Integer supplierId;
}
