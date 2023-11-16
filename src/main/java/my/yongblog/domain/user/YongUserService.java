package my.yongblog.domain.user;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface YongUserService {
    Long join(YongSaveRequest dto);

    Optional<Yong> getEmail(String email);
}
