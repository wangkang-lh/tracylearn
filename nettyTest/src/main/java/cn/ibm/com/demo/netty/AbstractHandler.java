package cn.ibm.com.demo.netty;

public abstract class AbstractHandler {
    /**
     * 处理器，这个处理将数据处理里向下传递
     */
    abstract void doHandler(HandlerChainContext handlerChainContext, Object arg0);
}
