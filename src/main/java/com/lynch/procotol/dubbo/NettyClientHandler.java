package com.lynch.procotol.dubbo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by lynch on 2019-08-24. <br>
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    // 接收server端的消息，并打印出来
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
    }

}
