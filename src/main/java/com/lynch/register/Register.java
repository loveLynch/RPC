package com.lynch.register;

import com.lynch.framework.URL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lynch on 2019-08-23. <br>
 * 注册中心
 **/
public class Register {
    private static Map<String, Map<URL, Class>> REGISTER = new HashMap<String, Map<URL, Class>>();

    /**
     * @param url           url
     * @param interfaceName 服务接口名
     * @param implClass     实现类
     */
    public static void register(URL url, String interfaceName, Class implClass) {
        Map<URL, Class> map = new HashMap<URL, Class>();
        map.put(url, implClass);
        REGISTER.put(interfaceName, map);
        saveFile();


    }


    /**
     * 获取实现类
     *
     * @param interfaceName
     * @return
     */
    public static Class get(URL url, String interfaceName) {
        REGISTER = getFile();
        return REGISTER.get(interfaceName).get(url);
    }


    /**
     * 获取服务地址
     * 随机策略
     *
     * @param interfaceName
     * @return
     */
    public static URL random(String interfaceName) {
        REGISTER = getFile();
        return REGISTER.get(interfaceName).keySet().iterator().next();
    }

    /**
     * Map存进文件系统
     */
    private static void saveFile() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/lynch/Documents/Idea/rpc/src/main/resources/map.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件系统中获取Map
     *
     * @return
     */
    private static Map<String, Map<URL, Class>> getFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/lynch/Documents/Idea/rpc/src/main/resources/map.txt");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            return (Map<String, Map<URL, Class>>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
