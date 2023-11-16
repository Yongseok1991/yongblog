package my.yongblog.domain.auth;

import java.util.List;

public interface RoleService {

    List<Role> userRoles(List<RoleType> roleTypes);
}
