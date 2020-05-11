package cn.ibm.com.demo.netty;

/**
 * handler上下文，我主要负责维护链，和链的执行
 */
public class HandlerChainContext {
    HandlerChainContext next; // 下一个handler节点
    AbstractHandler handler;

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
