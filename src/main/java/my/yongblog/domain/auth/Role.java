package my.yongblog.domain.auth;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseEntity;
import my.yongblog.domain.base.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "role")
    private List<YongRoles> yongRoles = new ArrayList<>();
    private String desc;
    private Boolean enabled;

    public Role(RoleType roleType, String desc, Boolean enabled) {
        this.roleType = roleType;
        this.desc = desc;
        this.enabled = enabled;
    }
}
