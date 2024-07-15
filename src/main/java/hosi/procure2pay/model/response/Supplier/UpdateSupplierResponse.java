package hosi.procure2pay.model.response.Supplier;

import lombok.Data;

@Data
public class UpdateSupplierResponse {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
}
