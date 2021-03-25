package cn.yajienet.demo.Interceptors;

import cn.yajienet.demo.annotation.DemoAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 17:50
 */
@Component
@Slf4j
public class DemoInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("preHandle:{}",request.getRequestURI());
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(DemoAnnotation.class)){
                log.info("添加了 @DemoAnnotation 注解");
                DemoAnnotation demoAnnotation = handlerMethod.getMethodAnnotation(DemoAnnotation.class);
                assert demoAnnotation != null;
                log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle:{}",request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion:{}",request.getRequestURI());
    }
}
