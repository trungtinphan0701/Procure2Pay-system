package hosi.procure2pay.model.response.Requisition;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateRequisitionResponse {
    private Integer requisitionId;
    private String supplierName;
    private String userFirstName;
    private String userLastName;
    private LocalDateTime createdOn;
    private Float totalCost;
    private String code;
    private String reference;
    private LocalDate deliveryDate;
}
