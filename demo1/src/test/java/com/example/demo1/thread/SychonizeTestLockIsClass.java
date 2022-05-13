package com.example.demo1.thread;

import com.example.demo1.javassit.Usera;

public class SychonizeTestLockIsClass {


    /**
     * 测试的是加锁，锁是class对象。作用在静态方法默认的锁对象 是当前类的class文件
     *
     * @param args
     */
    static int i = 0;



    public static void main(String[] args) {

        Usera usera = new Usera();//一个实例

        new Thread("线程1") {
            @Override
            public void run() {
                SychonizeTestLockIsClass a = new SychonizeTestLockIsClass();
                 a.test();
            }
        }.start();


        new Thread("线程4") {
            @Override
            public void run() {
                SychonizeTestLockIsClass a = new SychonizeTestLockIsClass();
                  a.test();
            }
        }.start();

        new Thread("线程2") {
            @Override
            public void run() {
                SychonizeTestLockIsClass a = new SychonizeTestLockIsClass();
                a.test2(usera);
            }
        }.start();

        new Thread("线程3") {
            @Override
            public void run() {
                SychonizeTestLockIsClass a = new SychonizeTestLockIsClass();
                a.test2(usera);
            }
        }.start();

    }


    private void test() {
        //这样的使用calss加锁，相当于是静态方法test3的写法。
        synchronized (Usera.class) {
            System.out.println(Thread.currentThread().getName() + "class执行方法");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized static void test3() {

    }


    private void test2(Usera usera) {
        synchronized (usera) {
            System.out.println(Thread.currentThread().getName() + "user实例加锁开始");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "user实例加锁结束");
        }
    }
}
