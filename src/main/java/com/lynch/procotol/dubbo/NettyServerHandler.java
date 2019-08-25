package com.lynch.procotol.dubbo;

import com.lynch.framework.Invocation;
import com.lynch.framework.URL;
import com.lynch.register.Register;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;


/**
 * Created by lynch on 2019-08-24. <br>
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().localAddress();
        Class implClass = Register.get(new URL(inetSocketAddress.getHostName(), inetSocketAddress.getPort()), invocation.getInterfaceName());


        Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        Object result = method.invoke(implClass.newInstance(), invocation.getParams());

        System.out.println("Netty-----" + result.toString());
        ctx.writeAndFlush("Netty: " + result);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

}
