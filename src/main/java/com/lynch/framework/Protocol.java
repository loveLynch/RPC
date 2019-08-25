package com.lynch.framework;

/**
 * Created by lynch on 2019-08-24. <br>
 * 协议接口
 **/
public interface Protocol {
    void start(URL url);

    String send(URL url, Invocation invocation);
}
