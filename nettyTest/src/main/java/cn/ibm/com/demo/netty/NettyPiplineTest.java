package cn.ibm.com.demo.netty;

// -----链表形式调用------netty就是类似的这种形式
class NettyPiplineTest {
    /**
     * 初始化的时候造一个head，作为责任链的开始，但是并没有具体的处理
     */
    public HandlerChainContext headContext = null;

    public NettyPiplineTest() {
        this.headContext = new HandlerChainContext(new AbstractHandler() {
            @Override
            void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
                handlerChainContext.findNextContext(arg0);
            }
        });
    }

    public void requestProcess(Object arg0) {
        System.out.println(arg0.toString());
        this.headContext.handler(null);
    }

    public void addLast(AbstractHandler handler) {
        HandlerChainContext context = headContext;
        while (context.next != null) {
            context = context.next;
        }
        context.next = new HandlerChainContext(handler);
    }


    public static void main(String[] args) {
        NettyPiplineTest nettyPiplineTest = new NettyPiplineTest();
        nettyPiplineTest.addLast(new Handler1());
        nettyPiplineTest.addLast(new Handler2());
        nettyPiplineTest.addLast(new Handler3());
        nettyPiplineTest.addLast(new Handler4());

        // 发起请求
        nettyPiplineTest.requestProcess("开始做月饼...");
    }
}


