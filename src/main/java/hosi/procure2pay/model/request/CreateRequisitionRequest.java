package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
// User input
public class CreateRequisitionRequest {
    private Integer userId;
    private Integer supplierId;
}
