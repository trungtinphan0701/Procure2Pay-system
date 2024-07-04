package hosi.procure2pay.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RequisitionResponse {
    private Integer requisitionId;
    private Integer createdByUserId;
    private LocalDateTime createdOn;
    private String state;
    private Float totalCost;
}
