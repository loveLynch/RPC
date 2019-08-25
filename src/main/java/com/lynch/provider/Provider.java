package com.lynch.provider;

import com.lynch.framework.Protocol;
import com.lynch.framework.ProtocolFactory;
import com.lynch.framework.URL;
import com.lynch.provider.api.HelloService;
import com.lynch.provider.impl.HelloServiceImpl;
import com.lynch.register.Register;

/**
 * Created by lynch on 2019-08-24. <br>
 * 服务者
 **/
public class Provider {
    public static void main(String[] args) {
        //注册服务
        URL url = new URL("localhost", 8080);
        Register.register(url, HelloService.class.getName(), HelloServiceImpl.class);

        //启动tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
