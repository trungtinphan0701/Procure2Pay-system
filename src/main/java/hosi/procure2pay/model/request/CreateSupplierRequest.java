package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateSupplierRequest {
    private String name;
    private String address;
    private String phoneNumber;
}
