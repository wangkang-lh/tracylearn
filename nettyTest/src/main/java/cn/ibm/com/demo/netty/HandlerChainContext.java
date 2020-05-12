package cn.ibm.com.demo.netty;

/**
 * 处理链路的上下文节点，在此节点上持有下一个节点以及当前节点的进行处理的handler
 */
public class HandlerChainContext {
    HandlerChainContext next; // 下一个链路节点
    AbstractHandler handler; //当前处理handler

    public HandlerChainContext(AbstractHandler handler) {
        this.handler = handler;
    }

    void handler(Object arg0) {
        this.handler.doHandler(this, arg0);
    }

    /**
     * 继续执行下一个handler
     */
    void findNextContext(Object arg0) {
        if (this.next != null) {
            this.next.handler(arg0);
        }
    }
}
