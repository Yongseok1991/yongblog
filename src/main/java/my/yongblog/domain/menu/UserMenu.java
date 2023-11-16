package my.yongblog.domain.menu;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.auth.Role;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserMenu {
    @Id @GeneratedValue
    @Column(name = "user_menu_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
