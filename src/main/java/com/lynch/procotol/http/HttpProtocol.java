package com.lynch.procotol.http;

import com.lynch.framework.Invocation;
import com.lynch.framework.Protocol;
import com.lynch.framework.URL;

/**
 * Created by lynch on 2019-08-24. <br>
 **/
public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());

    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();

        return httpClient.post(url.getHostname(), url.getPort(), invocation);
    }
}
