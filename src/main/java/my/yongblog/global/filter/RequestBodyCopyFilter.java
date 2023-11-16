package my.yongblog.global.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestBodyCopyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String contentType = req.getContentType();


        if (contentType == null || !contentType.contains("multipart/form-data")) {
            req = new CachedBodyHttpServletRequest((HttpServletRequest) req);
            ServletInputStream inputStream = req.getInputStream();
            chain.doFilter(req, res);
        }
    }
}
