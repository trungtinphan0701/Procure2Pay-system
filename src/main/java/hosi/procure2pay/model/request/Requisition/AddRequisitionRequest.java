package hosi.procure2pay.model.request.Requisition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddRequisitionRequest {
    private Integer supplierId;
}
