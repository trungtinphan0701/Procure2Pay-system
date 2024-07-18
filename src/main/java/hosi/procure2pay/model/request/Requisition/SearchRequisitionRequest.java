package hosi.procure2pay.model.request.Requisition;

import hosi.procure2pay.model.enums.RequisitionState;
import hosi.procure2pay.utils.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SearchRequisitionRequest {
    private String code;
    private RequisitionState state;
    private String supplierItem;
    private String fromDate;
    private String toDate;
    private Float minTotalCost = - Float.MIN_VALUE;
    private Float maxTotalCost = Float.MAX_VALUE;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    private Integer pageNumber = Constants.DEFAULT_PAGE_NUMBER;

}
