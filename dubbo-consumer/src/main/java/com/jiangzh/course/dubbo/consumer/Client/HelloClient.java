package com.jiangzh.course.dubbo.consumer.Client;

import com.jiangzh.course.dubbo.service.HelloServiceAPI;

public class HelloClient {

    public static void main(String[] args) {

        HelloServiceAPI helloServiceAPI = null;

        String message = helloServiceAPI.sayHello("Jiangzh");

        System.out.println(" message = "+ message);
    }

}
