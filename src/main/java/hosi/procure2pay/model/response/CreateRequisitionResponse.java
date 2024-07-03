package hosi.procure2pay.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateRequisitionResponse {
    private Integer requisitionId;
    private String supplierName;
    private String userFirstName;
    private String userLastName;
    private LocalDateTime createdOn;
    private Float totalCost;
}
