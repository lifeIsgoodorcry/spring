package com.example.demo1.suanfa.sort.suanfa;

public class Test2 {



    //数组出现了奇数次的数
    public static void main(String[] args) {
        int[] arr=new int[5];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        arr[3]=9;
        arr[4]=9;
        //arr中只有一个数  出现奇数次
        int c=0;
        for (int i : arr) {
             c= c^i;
        }
        /**
         * 课程 当前时间12点， 1小时之后， 直播时间在1点的，要进行通只。 1点之后的不通知。
         *
         * 直播时间在11点之前。
         */
        System.out.println(c);
    }
}
