package com.example.demo1.thread;

public class LockSupport {


    static final char[] c1 = new char[]{'1', '2', '3', '4', '5'};

    static char[] c2 = new char[]{'a', 'b', 'c', 'd', 'f'};

    static Thread t2 = null;
    static Thread t1=null;
    public static void main(String[] args) {

        t1 = new Thread() {
            @Override
            public void run() {

                for (char c : c1) {
                    System.out.println(c);
                    java.util.concurrent.locks.LockSupport.unpark(t2);
                    java.util.concurrent.locks.LockSupport.park();
                }
                java.util.concurrent.locks.LockSupport.unpark(t2);
            }
        };
        t1.start();

        t2 = new Thread() {
            @Override
            public void run() {
                java.util.concurrent.locks.LockSupport.park();
                for (char c : c2) {
                    System.out.println(c);
                    java.util.concurrent.locks.LockSupport.unpark(t1);
                    java.util.concurrent.locks.LockSupport.park();
                }
                //为了退出程序
                java.util.concurrent.locks.LockSupport.unpark(t1);
            }

        };
        t2.start();



    }
}
