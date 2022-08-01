package com.jiangzh.course.dubbo.consumer.Client;

import com.jiangzh.course.dubbo.service.HelloServiceAPI;

public class ConsumerClientProxy implements HelloServiceAPI {
    @Override
    public String sayHello(String message) {
        /*
            HTTPClient ， 调用dubbo-producer里面的HelloServiceImpl里面的sayHello
            HTTPClient client = doGet("producerURL,PORT, 接口名");
            String message = client.doResponse();
            return message;
        */
        return null;
    }
}
