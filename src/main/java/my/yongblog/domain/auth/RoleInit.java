package my.yongblog.domain.auth;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import my.yongblog.domain.menu.Menu;
import my.yongblog.domain.menu.MenuRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleInit {
    private final RoleRepository roleRepository;
    private final MenuRepository menuRepository;
    @PostConstruct
    public void init() {
        Role role1 = new Role(RoleType.ROLE_USER, "유저권한", true);
        Role role2 = new Role(RoleType.ROLE_ADMIN, "관리자권한", true);
        roleRepository.save(role1);
        roleRepository.save(role2);
        Menu menu1 = Menu.menuCreatorBuilder()
                .menuNm("root")
                .parent(null)
                .url("/")
                .build();
        Menu menu2 = Menu.menuCreatorBuilder()
                .menuNm("대시보드")
                .parent(menu1)
                .url("/dashboard")
                .build();
        Menu menu3 = Menu.menuCreatorBuilder()
                .menuNm("유저게시판")
                .parent(menu1)
                .url("/users")
                .build();
        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);



    }
}
