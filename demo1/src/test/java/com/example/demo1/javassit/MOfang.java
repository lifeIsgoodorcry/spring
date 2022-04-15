package com.example.demo1.javassit;


import javassist.expr.NewExpr;
import org.json.JSONException;
import org.json.JSONObject;

public class MOfang extends Usera{

    private String ename = "yy";
    private int eno = 1;

    public String getEname() {
        return this.ename;
    }

    public void setEname(String var1) {
        this.ename = var1;
    }

    public int getEno() {
        return this.eno;
    }

    public void setEno(int var1) {
        this.eno = var1;
    }


    /**
     *
     *
     *         String ret = XPocket.plugin("top_x").invoke("getresourcesjson");
     *         JSONObject object = JSONObject.parseObject(ret);
     *         result.setResult(true);
     *         result.setMessage("");
     *         //0 折线 1柱状 2饼状
     *         JSONObject cpuObject = object.getJSONObject("Cpu");
     *         result.put(0,cpuObject.toJSONString());
     *
     *         JSONObject memoryObject = object.getJSONObject("Memory");
     *         result.put(0,memoryObject.toJSONString());
     *
     *         JSONObject swapObject = object.getJSONObject("Swap");
     *         result.put(0,swapObject.toJSONString());
     *
     *         JSONObject ioObject = object.getJSONObject("IO");
     *         result.put(0,ioObject.toJSONString());
     *
     *         JSONObject systemObject = object.getJSONObject("System");
     *         result.put(0,systemObject.toJSONString());
     *
     *         JSONObject procObject = object.getJSONObject("PROC");
     *         result.put(0,procObject.toJSONString());
     */
    public void printInfo() {
        System.out.println("begin!");
        System.out.println(this.ename);
        System.out.println(this.eno);
        System.out.println("over!");
    }

    public Result call() throws InterruptedException, JSONException {
        System.out.println("执行call方法");
        String invoke = com.example.demo1.javassit.Xpocket.plugin("123").invoke("命令");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("123","ewrew");
        com.example.demo1.javassit.Result result = new com.example.demo1.javassit.Result();
        result.setData(invoke);
        return result;
    }
}
