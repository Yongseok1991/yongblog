package my.yongblog.domain.auth;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleInit {
    private final RoleRepository roleRepository;
    @PostConstruct
    public void init() {
        Role role1 = new Role(RoleType.ROLE_USER, "유저권한", true);
        Role role2 = new Role(RoleType.ROLE_ADMIN, "관리자권한", true);
        roleRepository.save(role1);
        roleRepository.save(role2);
    }
}
