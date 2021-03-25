package cn.yajienet.demo.aop;

import cn.yajienet.demo.annotation.DemoAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description 注释的是例外一种方法
 * @Author WangChenguang
 * @Date 2021-03-25 19:40
 */
@Aspect
@Component
@Slf4j
public class DemoAnnotationAspect {

    /**
     * 此处进入到方法前  可以实现一些业务逻辑
     * @param joinPoint JoinPoint
     */
    @Before("@annotation(demoAnnotation)")
    public void beforePointcut(JoinPoint joinPoint, DemoAnnotation demoAnnotation){
        log.info("beforePointcut:");
        log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
    //环绕通知：灵活自由的在目标方法中切入代码
    @Around("@annotation(demoAnnotation)")
    public Object doAround(ProceedingJoinPoint joinPoint, DemoAnnotation demoAnnotation) throws Throwable {
        log.info("doAround:");
        log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     * @param joinPoint JoinPoint
     */
    @AfterReturning("@annotation(demoAnnotation)")
    public void doAfterReturning(JoinPoint joinPoint, DemoAnnotation demoAnnotation){
        log.info("doAfterReturning:");
        log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }



//    @Pointcut("@annotation(cn.yajienet.demo.annotation.DemoAnnotation)")
//    public void DemoAnnotation(){}
//
//    /**
//     * 此处进入到方法前  可以实现一些业务逻辑
//     * @param joinPoint JoinPoint
//     */
//    @Before("DemoAnnotation()")
//    public void beforePointcut(JoinPoint joinPoint){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        DemoAnnotation demoAnnotation = method.getAnnotation(DemoAnnotation.class);
//        log.info("beforePointcut:");
//        log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//    }
//    //环绕通知：灵活自由的在目标方法中切入代码
//    @Around("DemoAnnotation()")
//    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        DemoAnnotation demoAnnotation = method.getAnnotation(DemoAnnotation.class);
//        log.info("doAround:");
//        log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        return joinPoint.proceed();
//    }
//
//    /**
//     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
//     * @param joinPoint JoinPoint
//     */
//    @AfterReturning("DemoAnnotation()")
//    public void doAfterReturning(JoinPoint joinPoint){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        DemoAnnotation demoAnnotation = method.getAnnotation(DemoAnnotation.class);
//        log.info("doAfterReturning:");
//        log.info("注解的值：name - {}   value - {}",demoAnnotation.name(),demoAnnotation.value());
//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//    }
}
