package hosi.procure2pay.model.response.Requisition;

import hosi.procure2pay.model.enums.RequisitionState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeclineRequisitionResponse {
    private Integer id;
    private RequisitionState state;
}
