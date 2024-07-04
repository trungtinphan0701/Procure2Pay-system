package hosi.procure2pay.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum RequisitionState {
    APPROVED(1, "Approved"),
    DECLINED(2, "Declined"),
    AWAITING_APPROVAL(3, "Awaiting Approval");

    private Integer stateId;
    private String stateName;

    private static Map<Integer, RequisitionState> requisitionStateMap;

    static {
        initRequisitionStateMap();
    }

    RequisitionState(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    private static void initRequisitionStateMap() {
        requisitionStateMap = new HashMap<Integer, RequisitionState>();
        for (RequisitionState RequisitionState : values()) {
            requisitionStateMap.put(RequisitionState.stateId, RequisitionState);
        }
    }

    public Integer getStateId() {
        return stateId;
    }

    public String getStateName() {
        return stateName;
    }
}
