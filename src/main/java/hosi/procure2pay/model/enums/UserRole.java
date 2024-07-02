package hosi.procure2pay.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserRole {
    GENERAL_MANAGER(1, "General Manager"),
    DEPARTMENT_MANAGEMENT(2, "Department Manager"),
    SUPERVISOR(3, "Supervisor"),
    STAFF(4, "Staff");

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
