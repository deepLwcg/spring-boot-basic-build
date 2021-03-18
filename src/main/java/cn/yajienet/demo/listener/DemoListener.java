package cn.yajienet.demo.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 19:09
 */

@WebListener
@Slf4j
public class DemoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("--------------------------------------");
        log.info("contextInitialized:{}",sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("--------------------------------------");
        log.info("contextDestroyed:{}",sce.getServletContext().getServerInfo());
    }
}
