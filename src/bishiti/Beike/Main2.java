package bishiti.Beike;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] num = new int[n][2];

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                num[i][j] = scanner.nextInt();
            }
        }

        fun(n, num);
        scanner.close();
    }

    private static void fun(int n, int[][] num) {
        int minRange = 0;
        int maxRange = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            set = new HashSet<Integer>();
            set.add(num[i][0]);
            minRange = num[i][0] + 1;
            maxRange = num[i][0] + num[i][1] - 1;
            for (int j = 0; j < num.length; j++) {
                if (maxRange >= num[j][0] && num[j][0] >= minRange) {
                    set.add(num[j][0]);
                    if (maxRange < (num[j][0] + num[j][1] - 1)) {
                        maxRange = num[j][0] + num[j][1] - 1;
                    }

                }
            }
            System.out.print(set.size() + " ");
        }

    }


}