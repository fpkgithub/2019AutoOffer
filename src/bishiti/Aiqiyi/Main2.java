package bishiti.Aiqiyi;

import java.util.Scanner;

/**
 * 题目描述：
 * 局长有N种食物，每种食物有Ai份。
 * 每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
 * 现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）
 * N,M,P<=100,Ai<=1000
 * 输入
 * 第一行N M P
 * 第二行N个数Ai
 * 接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i
 * 输出
 * 一个答案
 * 样例输入
 * 3 4 2
 * 5 3 1
 * B 1
 * A 2
 * A 2
 * A 3
 * 样例输出
 * 1
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] sarr = s.split(" ");
            if (sarr[0].equals("A")) {
                arr[Integer.parseInt(sarr[1]) - 1]++;
            }
            if (sarr[0].equals("B")) {
                arr[Integer.parseInt(sarr[1]) - 1]--;
            }
        }

        int temp = arr[p - 1];
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (i != (p - 1)) {
                if (arr[i] > temp) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}