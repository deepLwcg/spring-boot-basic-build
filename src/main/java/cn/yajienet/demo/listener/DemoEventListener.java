package cn.yajienet.demo.listener;

import cn.yajienet.demo.event.DemoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 19:17
 */
@Slf4j
@Component
public class DemoEventListener {


    @EventListener
    public void app(ApplicationEvent event){
        if (event instanceof DemoEvent){
            log.info("在当前线程处理事件：");
            log.info( ((DemoEvent) event).getMessage());
        }
    }

    @Async
    @EventListener
    public void demo(DemoEvent event){
        log.info("新启线程处理事件：");
        log.info(event.getMessage());
    }
}
