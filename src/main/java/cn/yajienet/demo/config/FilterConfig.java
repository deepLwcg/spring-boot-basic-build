package cn.yajienet.demo.config;

import cn.yajienet.demo.filter.DemoConfigFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 23:16
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DemoConfigFilter> demoFileFilterRegister(){
        FilterRegistrationBean<DemoConfigFilter> registration = new FilterRegistrationBean<>();
        //注入过滤器
        registration.setFilter(new DemoConfigFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("demoFilter");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }

}
