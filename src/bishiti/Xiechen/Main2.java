package bishiti.Xiechen;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }
        int res[] = getTime(a, arr);
        if (res.length == 0) {
            System.out.println("null");
        } else {
            for (int i : res) {
                System.out.println(i);
            }
        }

    }

    public static int[] getTime(int a, int arr[][]) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] <= a && arr[i][2] >= a) list.add(arr[i][0]);
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }


}