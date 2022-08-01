package com.jiangzh.course.dubbo.producer;

import com.jiangzh.course.dubbo.producer.impl.InJVMClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:applicationContext-dubbo.xml"})
public class DubboProducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DubboProducerApplication.class, args);

        //InJVMClient client =  (InJVMClient)context.getBean("inJVMClient");

        //client.inJVMTest(context, "inJvmProducer");

    }

}
