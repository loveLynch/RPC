package com.lynch.consumer;

import com.lynch.framework.ProxyFactory;
import com.lynch.provider.api.HelloService;

/**
 * Created by lynch on 2019-08-24. <br>
 * 消费者
 **/
public class Consumer {
    public static void main(String[] args) {
        //使用Spring可以直接使用容器
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("123456");
        System.out.println(result);

    }
}
