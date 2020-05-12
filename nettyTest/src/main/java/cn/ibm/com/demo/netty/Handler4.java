package cn.ibm.com.demo.netty;

public class Handler4 extends AbstractHandler {
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        System.out.println("接到指令，开始" + arg0.toString());
        System.out.println("我是工人4，我在处理：包装月饼...\n");
        // 继续执行下一个handler,最后一个调用链，可以不进行传值
        handlerChainContext.findNextContext(null);
    }
}
