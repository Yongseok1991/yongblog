package my.yongblog.global.web;

import my.yongblog.global.filter.RequestBodyCopyFilter;
import my.yongblog.global.interceptor.LoggingInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new LoggingInterceptor())
                .excludePathPatterns("/*.ico", "/assets/**", "/error");
    }
    @Bean
    public FilterRegistrationBean<RequestBodyCopyFilter> requestBodyCopyFilterRegistrationBean() {
        FilterRegistrationBean<RequestBodyCopyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestBodyCopyFilter());
        registrationBean.setOrder(0);
        return registrationBean;
    }
}
