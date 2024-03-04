package my.yongblog.global.audit;

import my.yongblog.global.auth.YongDetails;
import my.yongblog.global.util.UserUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class CustomAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (UserUtil.isAuthenticated(authentication)) {
            YongDetails loginUser = (YongDetails) authentication.getPrincipal();
            return Optional.of(loginUser.getId());             // ofNullable : return null
        } else {
            throw new IllegalStateException("id is not found");
        }
    }
}
