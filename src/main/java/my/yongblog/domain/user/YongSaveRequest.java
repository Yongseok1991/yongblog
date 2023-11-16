package my.yongblog.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.auth.RoleType;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YongSaveRequest {
    private String name;
    private String email;
    private String password;
    private String nickname;
    private Boolean isEnabled;
    private List<RoleType> roleType;

    public YongSaveRequest(String name, String email, String password, String nickname, Boolean isEnabled, List<RoleType> roleType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.isEnabled = isEnabled;
        this.roleType = roleType;
    }
}
