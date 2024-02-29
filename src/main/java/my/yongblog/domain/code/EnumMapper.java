package my.yongblog.domain.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class EnumMapper {
    @Bean
    public EnumMapperFactory createEnumMapperFactory() {
        EnumMapperFactory factory = new EnumMapperFactory(new LinkedHashMap<>());
//        factory.put("status", Status.class);
//        factory.put("use", Use.class);
        return factory;
    }
}
