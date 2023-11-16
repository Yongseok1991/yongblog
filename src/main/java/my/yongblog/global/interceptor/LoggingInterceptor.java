package my.yongblog.global.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import my.yongblog.global.filter.CachedBodyHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        final CachedBodyHttpServletRequest cachingRequest = (CachedBodyHttpServletRequest) request;
        if ("GET".equalsIgnoreCase(request.getMethod()) || "DELETE".equalsIgnoreCase(request.getMethod())) {
            List<String> params = new ArrayList<>();
            request.getParameterNames().asIterator().forEachRemaining(paramName -> params.add(paramName + " : " + request.getParameter(paramName)));
            log.info("parameter: {}", params);
            log.info("received [{} '{}' {}]", request.getMethod(), request.getRequestURI(), request.getProtocol());
            log.info("===============================================================");
        } else if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
            log.info("parameter: {}", new String(cachingRequest.getCachedBody(), StandardCharsets.UTF_8));
            log.info("received [{} '{}' {}]", request.getMethod(), request.getRequestURI(), request.getProtocol());
            log.info("===============================================================");
        }
    }
}
