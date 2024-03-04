package my.yongblog.domain.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseEntity;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.user.Yong;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YongRoles extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "yong_roles_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Yong yong;

    public YongRoles(Role role, Yong yong) {
        this.role = role;
        this.yong = yong;
    }
}
