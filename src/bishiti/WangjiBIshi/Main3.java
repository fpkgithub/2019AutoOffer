package bishiti.WangjiBIshi;


import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrs = new int[m];
        int[][] person = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arrs[x - 1]++;
            person[i][0] = x - 1;
            person[i][1] = y;
        }
        int count = 0;
        while (!panDuan(arrs)) {
            int max = getMaxVal(arrs);
            int nextnum = getNext(max, person, arrs);
            arrs[0]++;
            arrs[person[nextnum][0]]--;
            person[nextnum][0] = 0;
            count += person[nextnum][1];
        }
        System.out.println(count);
        sc.close();
    }


    public static boolean panDuan(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            if (arrs[i] >= arrs[0]) {
                return false;
            }
        }
        return true;
    }

    public static int getMaxVal(int[] arrs) {
        int max = 0;
        for (int i = 0; i < arrs.length; i++) {
            max = Math.max(max, arrs[i]);
        }
        return max;
    }

    public static int getNext(int max, int[][] person, int[] arrs) {
        int countNum = -1;
        double value = Double.MAX_VALUE;
        for (int i = 0; i < person.length; i++) {
            if (person[i][0] == 0) {
                continue;
            }
            if (max - arrs[0] > 1 && arrs[person[i][0]] == max) {
                double temp = person[i][1] / 2;
                if (temp < value) {
                    value = temp;
                    countNum = i;
                }
            } else {
                double temp = person[i][1];
                if (temp < value) {
                    value = temp;
                    countNum = i;
                }
            }
        }
        return countNum;
    }

}
