package bishiti.MeiTuan;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = countTallest(arr, k, t);
        System.out.println(res);
        scanner.close();
    }

    public static int countTallest(int[] arr, int k, int t) {
        int count = 0;
        int gap = k + 1;
        if (gap > arr.length) {
            return count;
        }
        if (t > k) {
            return count;
        }
        for (int l = 0; l < arr.length - k + 1; l++) {
            int r = l + k - 1;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = l; i <= r; i++) {
                if (map.containsKey(arr[i])) {
                    int value = map.get(arr[i]) + 1;
                    map.put(arr[i], value);
                } else {
                    map.put(arr[i], 1);
                }
            }
            for (Integer value : map.values()) {
                if (value.intValue() >= t) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}