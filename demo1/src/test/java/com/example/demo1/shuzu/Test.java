package com.example.demo1.shuzu;

public class Test {

    public static void main(String[] args) {
        int[][] arr = {{1,2},{4,5},{6}};
        printArr1(arr);
    }

    public static void printArr1(int[][] arr) {
        int[] a=new int[arr.length];

        int[] a1=new int[arr.length];
        int i=0;
        int j=0;
        for(int[] cells : arr) {
            //遍历一维数组中每一个元素
            if(cells.length>=2){
                 a[i]=cells[1];
                 i++;
            }
            if(cells.length>1){
                a1[j]=cells[0];
                j++;
            }
        }

        for (int i1 : a) {
            System.out.println(i1);
        }

    }

}
