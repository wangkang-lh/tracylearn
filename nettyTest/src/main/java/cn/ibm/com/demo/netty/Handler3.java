package cn.ibm.com.demo.netty;

public class Handler3 extends AbstractHandler {
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        System.out.println("接到指令，开始" + arg0.toString());
        System.out.println("我是工人3，我在处理：冷却月饼...\n");
        // 继续执行下一个handler
        handlerChainContext.findNextContext("包装月饼...");
    }
}
