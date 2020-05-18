package com.wangyuqiang.praticeDemo.algorithm.Sort;

import java.util.Arrays;

/**
 * 常用的排序算法列表实例:
 */
public class Order {

    /**
     * 冒泡排序:交换相邻位置元素:
     * 最好情况: 第一次就找到，最差情况:. 一直找，比如10个数，（9----1）； 10*9/2
     */
    static void bubbleSort() {
        int arr[] = new int[]{88, 72, 3, 12, 44, 15, 20, 40, 50, 70, 56};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * 选择排序，这个的意思是每次找出当前最小的一个，或者最大的一个，放在开始：
     * 不管什么样的数据，比如十个，就是9......1;
     */
    static void chooseSort() {
        int arr[] = new int[]{88, 72, 3, 12, 44, 15, 20, 40, 50, 20, 56};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * 插入排序算法:
     * 第一次是arr[0]和arr[1]
     * 第二次是arr[0] arr[1]和arr[2]找最小值:
     * 本质上是交换，比如前三个数，2  3  1 实际上是1 ，3 位置换(其实不是换，是1拿出来，然后先3往后挪，然后2往后挪,然后最后把1放在最开始位置)
     */
    static void insertSort() {
        int arr[] = new int[]{88, 72, 3, 12, 44, 15, 20, 40, 50, 20, 56};
        int preIndex;
        int currentValue;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            currentValue = arr[i]; // 2 3 1 中的  1 前面 2 3肯定是有序的
            while (preIndex >= 0 && arr[preIndex] > currentValue) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;//相当于不断挪位置的过程，先把3挪，然后2 ，
            }
            arr[preIndex + 1] = currentValue; //最后把1放在空出来的位置:
        }
        Arrays.stream(arr).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * 快速排序，本质上是基于基准值的排序:
     *
     * @param a
     * @param left
     * @param right
     */
    public static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int aimData = a[left];//基准值;
        int i = left;
        int j = right;
        while (i < j) {
            while (a[j] >= aimData && i < j) {//从右往左寻找小于基准值的值;
                j--;
            }
            while (a[i] <= aimData && i < j) {//从左往右寻找大于基准值的值;
                i++;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            //然后把基准值和中间值交换:
            a[left] = a[i];
            a[i] = aimData;
            //然后分段:
            quickSort(a, left, i - 1); //i位置刚好是基准值
            quickSort(a, i + 1, right);
        }
    }

    /**
     * 快速排序demo:
     */
    public static void testQuerySort() {
        int arr[] = new int[]{1, 72, 3, 12, 44, 15, 20, 40, 50, 20, 56};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * 希尔排序:
     * 核心思想在于，分成若干段，然后每次按照增量进行排序,然后逐渐缩小增量，再进行排序
     * 个人感觉可以看作一个差异化插入排序： 博文参考
     * https://blog.csdn.net/qq_39207948/article/details/80006224
     */
    static void shellSort() {
        int arr[] = new int[]{88, 72, 3, 12, 44, 15, 20, 40, 50, 20, 56};
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertSortGroup(arr, gap, i);
            }
        }
        Arrays.stream(arr).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * @param arr
     * @param gap 增量：根据不同增量对数据进行组内排序:
     * @param i
     */
    static void insertSortGroup(int[] arr, int gap, int i) {
        int insert = arr[i]; //拿出来的数据，可能用到 ，放到第一个，可能:
        int j;
        for (j = i - gap; j >= 0 && insert <= arr[j]; j -= gap) { //j需要一直递减:
            arr[j + gap] = arr[j]; //后面的值比前面的小，交换:
        }
        arr[j + gap] = insert;// 填充回去;
    }


    /**
     * 堆排序:
     *
     * @param arr
     * @param gap
     * @param i
     */
    static void heapSort(int[] arr, int gap, int i) {

    }


    public static void main(String[] args) {
//        bubbleSort();
//        chooseSort();
//        insertSort();
//        testQuerySort();
        // shellSort();
    }
}
