package com.jiangzh.course.dubbo.producer.filters;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

//@Activate(group = "provider")
public class MyProviderFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        URL url = invoker.getUrl();
        Class<?> anInterface = invoker.getInterface();
        String simpleName = anInterface.getSimpleName();
        String serviceName = invocation.getServiceName();
        String methodName = invocation.getMethodName();

        System.out.println("url = " + url.toFullString());
        System.out.println("simpleName = " + simpleName);
        System.out.println("serviceName = " + serviceName);
        System.out.println("methodName = " + methodName);
        // 调用下一级
        Result invoke = invoker.invoke(invocation);

        return invoke;
    }


}
