package bishiti.MeiTuan;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        fun(arr, k, t);*/
        int[] arr = {3, 1, 1, 1, 2};
        fun(arr, 3, 2);
        scanner.close();
    }

    //5 3 2
    //3 1 1 1 2
    //输出：4
    private static int fun(int[] arr, int k, int t) {

        int count = 0;
        int len = arr.length;
        int start = 0;
        int gap = k - 1; // r-l

        if (gap > len) {
            return 0;
        }

        while (start + gap < len) {
            Map map = new HashMap();


        }

        return count;
    }
}
