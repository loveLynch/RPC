package com.lynch.procotol.dubbo;

import com.lynch.framework.Invocation;
import com.lynch.framework.Protocol;
import com.lynch.framework.URL;

/**
 * Created by lynch on 2019-08-24. <br>
 **/
public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHostname(), url.getPort());

    }

    @Override
    public String send(URL url, Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(), url.getPort(), invocation);
    }
}
