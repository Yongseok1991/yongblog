package my.yongblog.global.auth;

import lombok.RequiredArgsConstructor;
import my.yongblog.domain.user.YongUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class YongUserDetailsService implements UserDetailsService {
    private final YongUserService yongUserService;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return yongUserService.getEmail(email)
                .map(yong -> {
                    yong.getYongRoles().forEach(role -> role.getRole().getRoleType());
                    return new YongDetails(yong);
                })
                .orElseThrow(() -> new IllegalArgumentException("email is not found"));
    }
}
