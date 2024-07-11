package hosi.procure2pay.model.request;

import hosi.procure2pay.model.enums.SupplierItemState;

public class UpdateSupplierItemRequest {
    private Integer id;
    private String name;
    private String description;
    private Float unitCost;
    private String type;
    private SupplierItemState supplierItemState;
}
