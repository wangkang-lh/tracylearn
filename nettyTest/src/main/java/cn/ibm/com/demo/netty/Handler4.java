package cn.ibm.com.demo.netty;

public class Handler4 extends AbstractHandler {
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        System.out.println("我是工人4，我在处理：包装月饼...");
        // 继续执行下一个handler
        handlerChainContext.findNextContext(null);
    }
}
