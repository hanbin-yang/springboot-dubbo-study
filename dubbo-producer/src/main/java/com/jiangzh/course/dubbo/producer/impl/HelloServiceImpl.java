package com.jiangzh.course.dubbo.producer.impl;

import com.jiangzh.course.dubbo.service.HelloServiceAPI;
import org.apache.dubbo.common.utils.NamedThreadFactory;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HelloServiceImpl implements HelloServiceAPI {
//    @Override
//    public String sayHello(String message) {
//        System.out.println("word : "+RpcContext.getContext().getAttachment("word"));
//
//        return "Producer response : Hello " +message;
//    }

    private ThreadPoolExecutor serviceThreadPool = new ThreadPoolExecutor(2,4,1,
            TimeUnit.MINUTES,
            new SynchronousQueue<>(),
            new NamedThreadFactory("jiangzh-threadpool"),
            new ThreadPoolExecutor.CallerRunsPolicy()
            );
    /*
        dubbo 高级特性之 异步执行
     */
    @Override
    public String sayHello(String message) {
        AsyncContext asyncContext = RpcContext.startAsync();
        serviceThreadPool.execute(()->{
            // 获取上下文信息使用
            asyncContext.signalContextSwitch();
            String  result = "Producer response : Hello " +message + ", thread : "+Thread.currentThread().getName();
            asyncContext.write(result);
        });
        return "hello, " +message;
    }

}
