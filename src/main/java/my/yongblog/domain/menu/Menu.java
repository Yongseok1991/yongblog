package my.yongblog.domain.menu;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @JoinColumn(name = "parent_id")
    private Menu parent;
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Menu> chlid = new ArrayList<>();
    private String url;
    @Builder(builderMethodName = "menuCreatorBuilder", builderClassName = "menuCreatorBuilder")
    public Menu(String menuNm, Menu parent, String url) {
        this.menuNm = menuNm;
        this.parent = parent;
        this.url = url;
    }
}
