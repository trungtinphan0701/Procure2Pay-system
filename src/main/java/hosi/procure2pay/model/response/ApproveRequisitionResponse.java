package hosi.procure2pay.model.response;

import hosi.procure2pay.model.enums.RequisitionState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApproveRequisitionResponse {
    private Integer requisitionId;
    private RequisitionState state;
}
