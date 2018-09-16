package bishiti.MeiTuan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n - 1][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(minR(arr));
        sc.close();
    }

    private static int minR(int[][] arr) {
        if (arr[0][0] == 1)
            return 4;
        //存最段路径
        Set<Integer> set = new HashSet<>();
        int minPath = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 1) {
                minPath++;
                set.add(arr[i][1]);
            }
        }

        if (set.isEmpty()) {
            return minPath;
        } else {
            for (int s : set) {
                int temp = 2;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][0] == s) {
                        minPath += temp;
                    }
                }
                temp++;
            }
        }
        return minPath;
    }
}
