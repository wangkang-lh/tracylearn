package cn.ibm.com.tracyfour.observerdemo.serviceImpl;

import cn.ibm.com.tracyfour.observerdemo.service.ObserverInterface;
import org.springframework.stereotype.Component;

@Component
public class OberserverImplFirst implements ObserverInterface {
    @Override
    public void ob() {
        System.out.println("this is the first impl");
    }
}
