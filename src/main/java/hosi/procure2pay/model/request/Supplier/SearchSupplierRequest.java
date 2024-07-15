package hosi.procure2pay.model.request.Supplier;

import hosi.procure2pay.utils.Constants;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SearchSupplierRequest {
    private String supplierName;
    private String address;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    private Integer pageNumber = Constants.DEFAULT_PAGE_NUMBER;
}
