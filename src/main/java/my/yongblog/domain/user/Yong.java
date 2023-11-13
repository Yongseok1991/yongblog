package my.yongblog.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.auth.YongRoles;
import my.yongblog.domain.base.BaseTimeEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Yong extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "yong_id")
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private Boolean isEnabled;

    @OneToMany(mappedBy = "yong", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<YongRoles> yongRoles = new HashSet<>();

}
