package my.yongblog.domain;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.yongblog.domain.code.EnumMapperFactory;
import my.yongblog.domain.code.EnumMapperValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final EnumMapperFactory enumMapperFactory;

    @GetMapping
    public String index() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @ResponseBody
    @PostMapping("/api/test")
    public String restTest() {

        List<EnumMapperValue> status = enumMapperFactory.get("status");
        List<EnumMapperValue> use = enumMapperFactory.get("use");
        status.forEach(x -> log.info("status: {} title : {}", x.getCode(), x.getTitle()));
        use.forEach(x -> log.info("use: {} title: {}", x.getCode(), x.getTitle()));
        return "ok";
    }
}
