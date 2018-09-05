package swordoffer.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopNOfHeap {

    public static void main(String[] args) {


        int[] arr = {3, 1, 4, 7, 5, 6, 2};

        printArr(arr);
        System.out.println();
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 2);
        for (Integer val : res) {
            System.out.print(val + " ");// 6 7
        }
        System.out.println();
        printArr(arr);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        int len = input.length;
        if (input == null || len == 0 || k == 0 || len < k) {
            return list;
        }

        //建立小堆：优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列。
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
       /* PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*/

        for (int i = 0; i < len; i++) {
            if (queue.size() != k)
                queue.offer(input[i]);
            else if (queue.peek() < input[i]) {
                Integer temp = queue.poll();
                queue.offer(input[i]);
            }
        }

        for (Integer val : queue) {
            list.add(val);
        }
        return list;
    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
