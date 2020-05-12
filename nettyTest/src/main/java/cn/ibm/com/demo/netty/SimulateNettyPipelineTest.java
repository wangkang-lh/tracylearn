package cn.ibm.com.demo.netty;

// -----链表形式调用------netty就是类似的这种形式
class SimulateNettyPipelineTest {
    //初始化的时候造一个head，作为责任链的开始
    public HandlerChainContext headContext = null;

    //构建链路的头节点
    public SimulateNettyPipelineTest() {
        this.headContext = new HandlerChainContext(new AbstractHandler() {
            @Override
            void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
                //寻找下一个执行节点
                handlerChainContext.findNextContext(arg0);
            }
        });
    }

    //发起调用请求
    public void requestProcess(Object arg0) {
        this.headContext.handler(arg0);
    }

    //将handler加入链路的最后，也就是“入队尾”
    public void addLast(AbstractHandler handler) {
        HandlerChainContext context = headContext;
        while (context.next != null) {
            context = context.next;
        }
        context.next = new HandlerChainContext(handler);
    }

    public static void main(String[] args) {
        SimulateNettyPipelineTest test = new SimulateNettyPipelineTest();
        test.addLast(new Handler1());
        test.addLast(new Handler2());
        test.addLast(new Handler3());
        test.addLast(new Handler4());
        // 发起请求
        test.requestProcess("开始做月饼...");
    }
}


