package cn.ibm.com.demo.netty;

public abstract class AbstractHandler {
    /**
     * 处理器，这个处理将数据处理并向下传递相关参数至下一个调用链路
     */
    abstract void doHandler(HandlerChainContext handlerChainContext, Object arg0);
}
