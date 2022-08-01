package com.jiangzh.course.dubbo.producer.impl;

import com.jiangzh.course.dubbo.service.HelloServiceAPI;
import org.apache.dubbo.common.utils.NamedThreadFactory;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HelloServiceImpl2 implements HelloServiceAPI {
    @Override
    public String sayHello(String message) {
        System.out.println("word : "+RpcContext.getContext().getAttachment("word"));

        return "Producer response 2 : Hello " +message;
    }
}
