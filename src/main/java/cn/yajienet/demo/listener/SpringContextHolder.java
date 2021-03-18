package cn.yajienet.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-02-07 3:31
 */
@Slf4j
@Component
public class SpringContextHolder implements ApplicationContextAware, ServletContextAware {

    private static ServletContext servletContext;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringContextHolder.applicationContext==null){
            log.info("setApplicationContext:-------------------------------------------");
            SpringContextHolder.applicationContext = applicationContext;
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        if(SpringContextHolder.servletContext==null){
            log.info("setServletContext:-------------------------------------------");
            SpringContextHolder.servletContext = servletContext;
        }
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName)
    {
        return applicationContext.getBean(beanName);
    }
    public static <T> T getBean(Class<T> beanName) {
        return applicationContext.getBean(beanName);
    }

}
