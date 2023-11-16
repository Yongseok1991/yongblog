package my.yongblog.domain.code;

import my.yongblog.domain.code.pojo.Status;
import my.yongblog.domain.code.pojo.Use;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class EnumMapper {
    @Bean
    public EnumMapperFactory createEnumMapperFactory() {
        EnumMapperFactory factory = new EnumMapperFactory(new LinkedHashMap<>());
        factory.put("status", Status.class);
        factory.put("use", Use.class);
        return factory;
    }
}
