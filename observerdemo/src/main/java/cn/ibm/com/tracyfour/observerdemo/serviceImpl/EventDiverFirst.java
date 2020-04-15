package cn.ibm.com.tracyfour.observerdemo.serviceImpl;

import cn.ibm.com.tracyfour.observerdemo.pojo.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventDiverFirst {
    @EventListener(value = {User.class})
    public void print() {
        System.out.println("this is a first event");
    }
}
