package com.lynch.procotol.http;


import com.lynch.framework.Invocation;
import com.lynch.framework.URL;
import com.lynch.register.Register;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * Created by lynch on 2019-08-23. <br>
 * 基于tomcat的http协议
 **/
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            //获取消费者请求
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) ois.readObject();

            //找实现类
            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8080);

            Class implClass = Register.get(url, interfaceName);

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            //写回消费者
            OutputStream outputStream = resp.getOutputStream();
            IOUtils.write("tomcat: " + result, outputStream);
            System.out.println("tomcat-----" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
