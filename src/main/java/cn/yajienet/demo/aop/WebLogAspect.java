package cn.yajienet.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 20:46
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    //切入点描述 这个是controller包的切入点
    @Pointcut("execution(public * cn.yajienet.demo.controller..*.*(..))")
    public void webLog(){}//签名，可以理解成这个切入点的一个名称

    //在切入点的方法run之前要干的
    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容,这个RequestContextHolder是SpringMVC提供来获得请求的东西
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }

}
