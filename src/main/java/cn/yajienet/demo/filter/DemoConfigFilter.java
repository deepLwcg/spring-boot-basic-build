package cn.yajienet.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 17:56
 */
@Slf4j
//@WebFilter
public class DemoConfigFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            log.info("DemoConfigFilter:{}",request.getRequestURI());
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
