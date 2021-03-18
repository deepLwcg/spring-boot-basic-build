package cn.yajienet.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description
 * @Author WangChenguang
 * @Date 2021-03-14 22:57
 */
public class DemoEvent extends ApplicationEvent {

    private String message;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    private DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
