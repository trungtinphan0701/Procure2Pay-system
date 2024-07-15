package hosi.procure2pay.model.request.SupplierItem;

import hosi.procure2pay.utils.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchSupplierItemRequest {

    private String supplierName;

    private Float minUnitCost = Float.MIN_VALUE;
    private Float maxUnitCost = Float.MAX_VALUE;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;

    private Integer pageNumber = Constants.DEFAULT_PAGE_NUMBER;


}
