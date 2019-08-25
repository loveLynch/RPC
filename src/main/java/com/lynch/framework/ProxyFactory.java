package com.lynch.framework;

import com.lynch.provider.api.HelloService;
import com.lynch.register.Register;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lynch on 2019-08-24. <br>
 * 动态代理
 **/
public class ProxyFactory<T> {
    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocol protocol = ProtocolFactory.getProtocol();
                Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Object[]{"123123"}, new Class[]{String.class});
                URL url = Register.random(interfaceClass.getName());//随机获取一个地址
                return protocol.send(url, invocation);
            }
        });
    }
}
