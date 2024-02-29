package my.yongblog.domain.user;

import lombok.RequiredArgsConstructor;
import my.yongblog.domain.code.EnumMapperFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
