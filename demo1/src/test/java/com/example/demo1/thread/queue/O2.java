package com.example.demo1.thread.queue;


import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class O2 {

    public static void main(String[] args) throws InterruptedException {

        TransferQueue<c1> queue = new LinkedTransferQueue<>();

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    while (true){
//                        c1 take = queue.take();
//                        System.out.println(take.name);
//                        if(queue.isEmpty()){
//                            return;
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();


        new Runnable() {
            @Override
            public void run() {
                int i = 0;
                //一直往里面加
                try {
                    queue.tryTransfer(new c1("任务" + i),1000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                System.out.println("放入成功了但是没有人取走，看看线程会不会继续执行，如果打印了说明线程没有等待结果取走");
                i++;
            }
        }.run();

    }


    static class c1 {
        String name;

        public c1(String name) {
            this.name = name;
        }
    }
}
