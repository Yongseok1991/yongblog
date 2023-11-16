package my.yongblog.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class YongUserRestController {

    private final YongUserService yongUserService;

    @PostMapping("/join")
    public ResponseEntity<Long> join(@RequestBody YongSaveRequest dto) {
        return ResponseEntity.ok(yongUserService.join(dto));
    }
}
