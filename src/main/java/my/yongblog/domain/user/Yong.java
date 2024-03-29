package my.yongblog.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.auth.Role;
import my.yongblog.domain.auth.YongRoles;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.dept.YongDepartment;
import my.yongblog.domain.leave.Leave;
import my.yongblog.domain.pos.YongPosition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "yong", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class Yong extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String nickname;

    private String email;
    private String password;
    private String name;
    private Boolean isEnabled;
    private String joinDate;
    @OneToOne
    @JoinColumn(name = "leave_id")
    private Leave leave;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private YongDepartment department;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private YongPosition position;

    @OneToMany(mappedBy = "yong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<YongRoles> yongRoles = new HashSet<>();

    @Builder(builderClassName = "yongSaveAndUpdateBuilder", builderMethodName = "yongSaveAndUpdateBuilder")
    public Yong(Long id, String nickname, String email, String password, String name, Boolean isEnabled, List<Role> roles) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.name = name;
        this.isEnabled = isEnabled;
        roles.forEach(r -> {
            YongRoles yongRoles = new YongRoles(r, this);
            this.yongRoles.add(yongRoles);
        });
    }
}
