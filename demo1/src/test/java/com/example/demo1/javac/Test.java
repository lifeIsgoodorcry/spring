package com.example.demo1.javac;

import com.google.gson.JsonObject;

public class Test {

    //从包名开始拷贝
    /**
     *  javac -cp /Users/qiuhua/Downloads/projects/spring/demo1/classes/   com/example/demo1/javac/Test.java
     */
    User user;

    JsonObject  jsonObject;


    public static void main(String[] args) {
        /**
         *
         *
         *  javac -cp /Users/qiuhua/Downloads/projects/spring/demo1/classes/:/Users/qiuhua/.m2/repository//com/google/code/gson/gson/2.8.9/gson-2.8.9.jar
         *  com/example/demo1/javac/Test.java
         */
        System.out.println("最新编译");

        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

}
