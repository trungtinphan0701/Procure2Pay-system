package hosi.procure2pay.model.response.Supplier;

import lombok.Data;

@Data
public class SupplierInfoResponse {
    private Integer supplierId;
    private String supplierName;
    private String address;
    private String phoneNumber;
}
