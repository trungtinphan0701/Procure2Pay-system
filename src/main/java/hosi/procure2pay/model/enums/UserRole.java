package hosi.procure2pay.model.enums;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public enum UserRole {
    ADMIN(1, "Admin"),
    PURCHASER(2, "Purchaser"),
    APPROVER(3, "Approver"),
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

    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}
