package my.yongblog.domain.menu;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.auth.Role;
import my.yongblog.domain.base.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;
    private String menuNm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "parent_id")
    private Menu parent;
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Menu> chlid = new ArrayList<>();
    private String url;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserMenu> menus = new ArrayList<>();
}
