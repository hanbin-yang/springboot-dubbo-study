package com.jiangzh.course.dubbo.producer.impl;

import com.jiangzh.course.dubbo.service.HelloServiceAPI;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

//@Service
public class InJVMClient {

    public void inJVMTest(ConfigurableApplicationContext context, String message){
        HelloServiceAPI injvmProvider = (HelloServiceAPI)context.getBean("injvmProvider");
        System.out.println(injvmProvider.sayHello(message));
    }

    /*
        不会调用Dubbo自身的任何机制
     */
    public void test(String message){
        HelloServiceAPI injvmProvider = new HelloServiceImpl();
        System.out.println(injvmProvider.sayHello(message));
    }

}
