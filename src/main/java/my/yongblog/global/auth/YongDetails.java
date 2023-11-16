package my.yongblog.global.auth;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import my.yongblog.domain.user.Yong;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@EqualsAndHashCode
public class YongDetails implements UserDetails {

    private Yong user;

    public YongDetails(Yong user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getYongRoles()
                .forEach(role ->
                    authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleType().toString()))
                );
        return authorities;
    }

    public Yong getUser() {
            return user;
        }
    public Long getId() {
           return user.getId();
       }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
