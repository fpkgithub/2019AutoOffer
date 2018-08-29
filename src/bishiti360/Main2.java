package bishiti360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入：5次看花  3种花
 * 5 3
 * 1 2 3 2 2
 * 3    3种问题
 * 1 4  问题1：第1次到第4次看了几种花
 * 2 4  问题2：第2次到第4次看了几种花
 * 1 5  问题3：第3次到第5次看了几种花
 * 输出：
 * 3
 * 2
 * 3
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        //凑字数
        int m = sc.nextInt();
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        int qNUm = sc.nextInt();
        int[] b1 = new int[qNUm];
        int[] b2 = new int[qNUm];
        while (count < qNUm) {
            b1[count] = sc.nextInt();
            b2[count] = sc.nextInt();
            count++;
        }
        for (int i = 0; i < b2.length; i++) {
            getTimes(a, b1[i], b2[i]);
        }
        sc.close();
    }

    private static void getTimes(int[] a, int start, int end) {
        Set<Integer> set = new HashSet<>();
        for (int i = start - 1; i < end; i++) {
            set.add(a[i]);
        }
        System.out.println(set.size());
    }
}