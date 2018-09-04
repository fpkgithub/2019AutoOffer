package bishiti.Beike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 因数 {
    public static boolean isPrime(int m) {
        for (int i = 2; i <= m / 2; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int minNum(int n) {
        if (n <= 2)
            return n;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && n != i) {
                n = n / i;
                list.add(i);
            }
            if (n == i) {
                list.add(i);
                break;
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        Arrays.sort(a);
        double product = 1;
        int k = 2;
        for (int i = a.length - 1; i >= 0; i--) {
            while (true) {
                if (isPrime(k)) {
                    product = product * Math.pow(k, a[i] - 1);
                    k++;
                    break;
                }
                k++;
            }
        }
        return (int) product;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(minNum(n));
    }

}