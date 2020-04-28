package cn.ibm.com.tracyfour.observerdemo.serviceImpl;

import cn.ibm.com.tracyfour.observerdemo.service.ObserverInterface;
import org.springframework.stereotype.Component;

@Component
public class OberserverImplSecond implements ObserverInterface {
    @Override
    public void ob() {
        System.out.println("this is a second impl");
    }
}
