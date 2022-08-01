package com.jiangzh.course.dubbo.service;

public interface HelloServiceAPI {

    /*
        传入一个Message，增加Hello的回复
     */
    String sayHello(String message);

}
