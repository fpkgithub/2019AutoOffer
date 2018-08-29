package bishiti.Haoweilai;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int[] arr_x = new int[count];
        int[] arr_k = new int[count];
        for (int i = 0; i < count; i++) {
            arr_x[i] = scanner.nextInt();
            arr_k[i] = scanner.nextInt();
        }

        for (int i = 0; i < count; i++) {
            int x = arr_x[i];
            int k = arr_k[i];
            int m = 0;
            int y = 0;
            while (m != k) {
                y++;
                if ((x + y) == (x | y)) {
                    m++;
                }
            }
            System.out.println(y);
        }
        scanner.close();
    }
}
