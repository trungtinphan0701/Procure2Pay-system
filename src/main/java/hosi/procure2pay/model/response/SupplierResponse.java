package hosi.procure2pay.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierResponse {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
}
