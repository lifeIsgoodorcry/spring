package com.example.demo1.javassit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayListString {


    public static void main(String[] args) throws Exception {

         ClassPool pool = ClassPool.getDefault();
        //通过ClassPool生成一个public新类Emp.java
         CtClass ctClass = pool.makeClass("com.study.javassist.Empx");

         CtClass list = pool.getCtClass("java.util.ArrayList");

         pool.importPackage("java.util.List");
         pool.importPackage("java.util.ArrayList");


        CtMethod call1 = new CtMethod(list, "call1", new CtClass[]{}, ctClass);
        call1.setModifiers(Modifier.PUBLIC);
        call1.setBody("{ System.out.println(\"执行call方法\");\n" +
                "  List list = new ArrayList();\n" +
                "        list.add(\"123\");"+
//                " for (Object string : list) {\n" +
//                "        System.out.println(string);\n" +
//                "     }"+
                "          return list;}");
        ctClass.addMethod(call1);

        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        Object o = obj.getClass().getMethod("call1", new Class[]{}).invoke(obj);
        System.out.println(o);




        //把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/qiuhua/Downloads/projects/spring/demo1/Emps.class"));
        fos.write(byteArr);
        fos.close();



    }







}
