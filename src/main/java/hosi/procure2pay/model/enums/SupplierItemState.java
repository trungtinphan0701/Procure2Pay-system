package hosi.procure2pay.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum SupplierItemState {
    IN_STOCK(1, "In stock"),
    OUT_OF_STOCK(2, "Out of stock");

    private Integer stateId;
    private String stateName;

    private static Map<Integer, SupplierItemState> supplierItemStateMap;

    static {
        initSupplierItemStateMap();
    }

    SupplierItemState(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    private static void initSupplierItemStateMap() {
        supplierItemStateMap = new HashMap<Integer, SupplierItemState>();
        for (SupplierItemState SupplierItemState : values()) {
            supplierItemStateMap.put(SupplierItemState.stateId, SupplierItemState);
        }
    }

    public Integer getStateId() { return stateId; }

    public String getStateName() { return stateName; }
}
