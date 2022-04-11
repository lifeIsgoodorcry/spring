package com.example.demo1.suanfa.sort;

public class Xuanze {

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
     * 从0位置开始看一遍n-1，找到最小的和0交换位置
     * 从1位置开始，看一遍n-1，找到最小的和1交换位置
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    //交换位置
                    swap(arr, i, j);
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
