package my.yongblog.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface YongRepository extends JpaRepository<Yong, Long> {
    Optional<Yong> findByEmail(@Param("email") String email);
}
