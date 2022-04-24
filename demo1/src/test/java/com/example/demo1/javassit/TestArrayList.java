package com.example.demo1.javassit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.io.File;
import java.io.FileOutputStream;

public class TestArrayList {


    public static void main(String[] args) throws Exception {

         ClassPool pool = ClassPool.getDefault();
        //通过ClassPool生成一个public新类Emp.java
         CtClass ctClass = pool.makeClass("com.study.javassist.Empx");

         CtClass list = pool.getCtClass("java.util.ArrayList");

        CtClass ts = pool.getCtClass("com.example.demo1.javassit.Usera");
        Class<?> aClass = ts.toClass();
        System.out.println(aClass.hashCode());

        pool.importPackage("java.util.List");
         pool.importPackage("java.util.ArrayList");
         pool.importPackage("com.example.demo1.javassit.Usera");


        CtMethod call1 = new CtMethod(list, "call1", new CtClass[]{}, ctClass);
        call1.setModifiers(Modifier.PUBLIC);
        call1.setBody("{ System.out.println(\"执行call方法llll\");\n" +
                 "     List strings = new ArrayList();\n" +
                "        strings.add(\"ewre\");\n" +
                "\n" +
                "        for (int i = 0; i < strings.size(); i++) {\n" +
                "            System.out.println(strings.get(i));\n" +
                "        }"+
                "   List strings2 = new ArrayList();\n" +
                "        Usera usera = new Usera();\n" +
                "        usera.setResult(false);\n" +
                "        strings2.add(usera);\n" +
                "        for (int i = 0; i < strings2.size(); i++) {\n" +
                "            Usera u = (Usera) strings2.get(i);"+
                "            System.out.println(u.getData());\n" +
                "        }"+
                "          return strings;}");
        ctClass.addMethod(call1);

        Class<?> clazz = ctClass.toClass();

        Object obj = clazz.newInstance();

        Object o = obj.getClass().getMethod("call1", new Class[]{}).invoke(obj);


        //把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/qiuhua/Downloads/projects/spring/demo1/Empx.class"));
        fos.write(byteArr);
        fos.close();



    }




}
