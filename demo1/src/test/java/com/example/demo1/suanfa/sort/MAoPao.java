package com.example.demo1.suanfa.sort;

public class MAoPao {

    public static void main(String[] args) {
        int[] a = new int[4];
        a[0] = 4;
        a[1] = 3;
        a[2] = 9;
        a[3] = 1;
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }


    /**
     * 两个数比较，谁大谁向后。交换位置两个数，大的在后面
     * 第一次 ： 0和1比较，1和2比交， 2和3比较 ，直到 n-1和n比较
     * 第二次：  0和1比较，1和2比交， 2和3比较 ，直到 n-2和n-1比较
     * <p>
     * 比如 3个数 2 1 6
     * 第一次 2和1，交换 1，2，6 ， 2和6比较，不交换   1，2，6
     * 第二次 1和2比较，不处理。结束。
     * 比较了 n-1次
     * <p>
     * 外层循环控制次数
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
