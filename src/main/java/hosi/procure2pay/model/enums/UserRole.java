package hosi.procure2pay.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserRole {
    PURCHASER(1, "Purchaser"),
    APPROVER(2, "Approver"),
    ADMIN(3, "Admin"),
    SUPPLIER_MANAGER(4, "Supplier Manager");

    private Integer roleId;
    private String roleName;

    private static Map<Integer, UserRole> userRoleMap;
    static {
        initUserRoleMap();
    }
    UserRole(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    private static void initUserRoleMap() {
        userRoleMap = new HashMap<Integer, UserRole>();
        for (UserRole userRole : values()) {
            userRoleMap.put(userRole.roleId, userRole);
        }
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
