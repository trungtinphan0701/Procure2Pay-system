package hosi.procure2pay.model.request.Supplier;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateSupplierRequest {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
}
