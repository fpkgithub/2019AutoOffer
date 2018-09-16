package bishiti.JingDong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        int input = scanner.nextInt();
        for (; input > 0; input--) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            //dp问题 初始化
            boolean[][] dp = new boolean[n + 1][n + 1];
            boolean[] dpFind = new boolean[n + 1];
            for (; m > 0; m--) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                dp[u][v] = true;
                dp[v][u] = true;
            }
            //result list
            List<List<Integer>> listAll = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (dpFind[i]) {
                    continue;
                }
                dpFind[i] = true;
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <= n; j++) {
                    if (!dp[i][j]) {
                        list.add(j);
                        dpFind[j] = true;
                    }
                }
                listAll.add(list);
            }
            int[] index = new int[n + 1];
            for (List<Integer> list : listAll) {
                for (int it : list) {
                    index[it]++;
                }
            }
            String res = "Yes";
            for (int i = 1; i <= n; i++) {
                if (index[i] != 1) {
                    res = "No";
                }
            }
            System.out.println(res);
        }
        scanner.close();
    }
}