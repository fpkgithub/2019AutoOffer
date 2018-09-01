package swordoffer.fourchapter;

import java.util.*;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 */
public class 最小的K个数 {
    public static void main(String[] args) {

        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        //ArrayList<Integer> res = findLastK(arr, 4);
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 4);
        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }

    private static ArrayList<Integer> findLastK(int[] arr, int num) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return list;
        for (int i = 0; i < num; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            list.add(arr[i]);
        }

        return list;

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = input.length;
        if (input == null || input.length == 0 || len < k || k == 0) {
            return list;
        }

        //使用优先队列建堆  大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < len; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            }
            else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer val : maxHeap) {
            list.add(val);
        }
        return list;
    }

}
