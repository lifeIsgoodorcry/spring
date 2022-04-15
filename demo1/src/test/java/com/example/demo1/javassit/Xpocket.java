package com.example.demo1.javassit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class Xpocket {

    /**
     * 调用的插件名字
     */
    private String plugin;
    private Usera usera=new Usera();
    private static Cache<String, String> xpocketCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build();

    private static Long XCENTER_INVOKE_TIMEUT=60*1000l;

    public Xpocket(String plugin) {
        this.plugin = plugin;
    }

    public static Xpocket plugin(String pluginName){
        return new Xpocket(pluginName);
    }


    public String invoke(String command) throws InterruptedException {
        System.out.println("执行调用方法");
        usera.ss();
        return "command";
    }
}
