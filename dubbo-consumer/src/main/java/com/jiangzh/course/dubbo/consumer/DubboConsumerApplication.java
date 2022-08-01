package com.jiangzh.course.dubbo.consumer;

import com.jiangzh.course.dubbo.service.HelloServiceAPI;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@ImportResource(locations = {"classpath:applicationContext-dubbo.xml"})
public class DubboConsumerApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(DubboConsumerApplication.class, args);

        HelloServiceAPI producerService = context.getBean("producerService", HelloServiceAPI.class);

        RpcContext.getContext().setAttachment("word","abc");

        String message = "I'm Jiangzh";
        // 正常调用
        System.out.println(producerService.sayHello(message));

        // <!-- 异步 -->
//        producerService.sayHello(message);
//        CompletableFuture<String> completableFuture = RpcContext.getContext().getCompletableFuture();
//        String result = completableFuture.get();
//        System.out.println("result : "+result);
    }

}
