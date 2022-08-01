package com.jiangzh.course.dubbo.producer.impl;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;

public class MainTest {

    public static void main(String[] args) {
        Protocol adaptiveExtension = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        System.out.println("end");
    }

}
