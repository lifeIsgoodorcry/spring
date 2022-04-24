package com.example.demo1.javassit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.codehaus.jettison.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class TestInnerClass {

    public static void main(String[] args) throws Exception{
        ClassPool pool = ClassPool.getDefault();
        //通过ClassPool生成一个public新类Emp.java
        CtClass ctClass = pool.makeClass("com.study.javassist.Empx");

        CtClass list = pool.getCtClass("java.util.ArrayList");

        pool.importPackage("java.util.List");
        pool.importPackage("java.util.ArrayList");
        pool.importPackage("com.example.demo1.javassit.Usera");
        pool.importPackage("org.codehaus.jettison.json.JSONObject");

        CtMethod call1 = new CtMethod(list, "call1", new CtClass[]{}, ctClass);
        call1.setModifiers(Modifier.PUBLIC);

        call1.setBody("{class Util {\n" +
                "        public JSONObject getXPocketContent(String pluginName, String cmd) throws Exception {\n" +
                "            \n" +
                "            JSONObject info = new JSONObject();\n" +
                "            info.put(\"qwe\",\"qwret\");\n" +
                "            return info;\n" +
                "        }\n" +
                "    }}");
        ctClass.addMethod(call1);

        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        Object o = obj.getClass().getMethod("call1", new Class[]{}).invoke(obj);


        //把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/qiuhua/Downloads/projects/spring/demo1/Empx1.class"));
        fos.write(byteArr);
        fos.close();
    }

}
