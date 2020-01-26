package link.yangxin.ajaxserver.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangxin
 * @date 2020/1/26
 */
public class MyCorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String origin = request.getHeader("Origin");
        if (!StringUtils.isEmpty(origin)) {
            response.addHeader("Access-Control-Allow-Origin",origin);
        }
        response.addHeader("Access-Control-Allow-Methods","*");

        String headers = request.getHeader("Access-Control-Request-Headers");
        if (!StringUtils.isEmpty(headers)) {
            response.addHeader("Access-Control-Allow-Headers",headers);
        }


        response.addHeader("Access-Control-Max-Age","3600");// 单位秒。告诉浏览器，在指定时间内，缓存设置的以上信息，不需要发送options请求
        response.addHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}