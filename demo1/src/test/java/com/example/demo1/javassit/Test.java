package com.example.demo1.javassit;

import javassist.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

public class Test {


    /**
     String ret = XPocket.plugin("top_x").invoke("getprocjson");
     StringBuilder message = new StringBuilder();
     JSONObject object = JSONObject.parseObject(ret);
     JSONObject totalObject = object.getJSONObject("Total");
     message.append("Total Processes: ").append(totalObject.getString("Total Processes:")).append("\n");
     message.append("Up Time: ").append(totalObject.getString("Up Time:")).append("\n");
     message.append("Users: ").append(totalObject.getString("Users:")).append("\n");
     message.append("CPU: ").append(totalObject.getString("CPU:")).append("\n");
     message.append("Memory: ").append(totalObject.getString("Memory:")).append("\n");


     result.setResult(true);
     result.setMessage(message.toString());
     //0 折线 1柱状 2饼状
     JSONObject processTypeObject = object.getJSONObject("ProcessType");
     result.put(2,processTypeObject.toJSONString());

     JSONObject memorySwapObject = object.getJSONObject("MemorySwap");
     result.put(1,memorySwapObject.toJSONString());

     JSONObject cpuObject = object.getJSONObject("CPU");
     result.put(1,cpuObject.toJSONString());

     JSONObject loadAvgObject = object.getJSONObject("LoadAvg");
     result.put(1,loadAvgObject.toJSONString());
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //ClassPool：CtClass对象的容器
        ClassPool pool = ClassPool.getDefault(); //可以设置加载类的路径

        //通过ClassPool生成一个public新类Emp.java
        CtClass ctClass = pool.makeClass("com.study.javassist.Emp");

        //设置父类 （本地已经存在的类）
        CtClass aClass1 = pool.get("com.example.demo1.javassit.Usera");
        System.out.println("Usera 的class : "+aClass1);
        ctClass.setSuperclass(aClass1);

         //设置导包吧
         pool.importPackage("com.example.demo1.javassit.Result");



        //添加字段属性
        //首先添加字段private String ename
        CtField enameField = new CtField(pool.getCtClass("java.lang.String"), "ename", ctClass);
        enameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameField);

        //其次添加字段privtae int eno
        CtField enoField = new CtField(pool.getCtClass("int"), "eno", ctClass);
        enoField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enoField);

        CtClass resultClass = pool.get(Result.class.getName()); //类型
       //复杂类型的属性

//        CtField f = CtField.make("public com.example.demo1.javassit.Result z = null;",resultClass);
//        ctClass.addField(f);

        //添加call方法  带返回值
        CtMethod call = new CtMethod(resultClass, "call", new CtClass[]{}, ctClass);
        call.setModifiers(Modifier.PUBLIC);
        call.setBody("{ System.out.println(\"执行call方法\");\n" +
                "         Result result = new Result();\n" +
                "        result.setData(\"123\");\n"   +
                "        return  result;}");
        CtClass etype = pool.get("java.io.IOException");
        call.addCatch("{ System.out.println($e); throw $e; }", etype);
        ctClass.addMethod(call);


        // 模仿写代码
//        CtMethod call1 = new CtMethod(resultClass, "call1", new CtClass[]{}, ctClass);
//        call1.setModifiers(Modifier.PUBLIC);
//        call1.setBody("{ System.out.println(\"执行call方法\");\n" +
//                "        String invoke = com.example.demo1.javassit.Xpocket.plugin(\"123\").invoke(\"命令\");\n" +
//                "        org.json.JSONObject jsonObject=new org.json.JSONObject();\n" +
//                         "jsonObject.put(\"123\",\"ewrew\");"+
//                "        com.example.demo1.javassit.Result result = new com.example.demo1.javassit.Result();\n" +
//                "        result.setData(invoke);\n" +
//                "        return result;}");
//        CtClass etype1 = pool.get("java.lang.Exception");
//        call1.addCatch("{ System.out.println($e); throw $e; }", etype1);
//        ctClass.addMethod(call1);



        //为字段ename和eno添加getXXX和setXXX方法
        ctClass.addMethod(CtNewMethod.getter("getEname", enameField));
        ctClass.addMethod(CtNewMethod.setter("setEname", enameField));
        ctClass.addMethod(CtNewMethod.getter("getEno", enoField));
        ctClass.addMethod(CtNewMethod.setter("setEno", enoField));


        //添加构造函数
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        //为构造函数设置函数体
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n")
                .append("ename=\"yy\";\n")
                .append("eno=001;\n}");
        ctConstructor.setBody(buffer.toString());
        //把构造函数添加到新的类中
        ctClass.addConstructor(ctConstructor);



        //添加自定义方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printInfo", new CtClass[]{}, ctClass);
        //为自定义方法设置修饰符
        ctMethod.setModifiers(Modifier.PUBLIC);
        //为自定义方法设置函数体
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append("{\nSystem.out.println(\"begin!\");\n")
                .append("System.out.println(ename);\n")
                .append("System.out.println(eno);\n")
                .append("System.out.println(\"over!\");\n")
                .append("}");
        ctMethod.setBody(buffer2.toString());
        ctClass.addMethod(ctMethod);

        //为了验证效果，下面使用反射执行方法printInfo
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        //把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/qiuhua/Downloads/projects/spring/demo1/Emp.class"));
        fos.write(byteArr);
        fos.close();

        Object o = obj.getClass().getMethod("call", new Class[]{}).invoke(obj);
        Result  r= (Result) o;
        System.out.println(r);
    }

}
