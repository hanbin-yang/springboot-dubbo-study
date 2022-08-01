package com.jiangzh.course.dubbo.consumer.service;

import org.springframework.stereotype.Service;

@Service(value = "producerCallbackService")
public class ProducerCallbackServiceImpl {

    /*
        doInvoker -> 参数类型与实际调用的方法要求一致
     */
    public void doInvoker(String message){
        System.out.println("doInvoker message : "+ message);
    }

    /*
        doReturn -> 可以有多个参数， 但是第一个参数类型一定要与实际调用方法的返回值一致。
        如果有多个参数， 则会填充实际调用方法的入参
     */
    public void doReturn(String response){
        System.out.println("doReturn response : "+ response);
    }

    /*
        doThrow -> 可以有多个参数， 但是第一个参数是Throwable
        如果有多个参数， 则会填充实际调用方法的入参
     */
    public void doThrow(Throwable throwable){
        System.out.println("doThrow throwable : "+ throwable.getMessage());
        throwable.getStackTrace();
    }

}
