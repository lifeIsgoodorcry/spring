package com.example.demo1.suanfa.sort;

public class Charu {

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
     * 插入：从0位置开始，比较0之前的元素，如果遇到比0大的，和0位置的交换.保证这个数之前的有序。
     * <p>
     * 比如 3个数 4(0),3(1),2(2),1(3),6(4)
     * 第一次1位置的数,保证1位置之前的有序： 3和4 （3，4，2，1，6）
     * 第二次2位置的数，保证2位置之前的有序： 2和4比较，交换 3，2，4， 然后 i-1的2和3比较，交换 2，3，4.保证了2位置之前的有序
     * <p>
     * 第三次3位置的数2， 2和2位置的数6比较，小。交换位置。1 2 2 6 2 3 ， 之后，2位置的和1位置的比较（2和1），不交换。结束、
     * <p>
     * 外层循环控制次数
     *
     * @param arr
     */
    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            //保证i之前的有序
            if (arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
                for (int j = i - 1; j < 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }else{
                        break;
                    }

                }
            }else{
                continue;
            }
        }


    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
