package hosi.procure2pay.model.response;

import lombok.Data;

@Data
public class CreateSupplierResponse {
    private Integer supplierId;
    private String supplierName;
    private String address;
    private String phoneNumber;
}
