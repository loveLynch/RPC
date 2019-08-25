package com.lynch.framework;

import com.lynch.procotol.dubbo.DubboProtocol;
import com.lynch.procotol.http.HttpProtocol;

/**
 * Created by lynch on 2019-08-24. <br>
 * 协议工厂，默认http
 **/
public class ProtocolFactory {
    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (name == null || name == "") name = "http";
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();

            default:
                break;
        }
        return new HttpProtocol();
    }
}
