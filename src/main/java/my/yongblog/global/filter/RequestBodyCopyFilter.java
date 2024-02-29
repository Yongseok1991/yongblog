package my.yongblog.global.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class RequestBodyCopyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String contentType = req.getContentType();
        if (contentType == null || !contentType.contains("multipart/form-data")) {
            CachedBodyHttpServletRequest cachedRequest = new CachedBodyHttpServletRequest((HttpServletRequest) req);
            cachedRequest.resetInputStream(modifyData(cachedRequest.getInputStream()));
            chain.doFilter(cachedRequest, res);
        }
    }

    public byte[] modifyData(InputStream stream) throws IOException {
        String data = IOUtils.toString(stream, Charset.defaultCharset());
        data = data.replace("email", "userEmail");
        return data.getBytes();
    }
}
