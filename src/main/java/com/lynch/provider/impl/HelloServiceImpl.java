package com.lynch.provider.impl;

import com.lynch.provider.api.HelloService;

/**
 * Created by lynch on 2019-08-23. <br>
 **/
public class HelloServiceImpl implements HelloService {
    public String sayHello(String username) {
        return "Hello: " + username;
    }
}
