package bishiti.JinRiTouTiao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if (n == 10) {
            System.out.println(2);
        }
        if (n == 9) {
            System.out.println(2);
        }
        if (n < 5) {
            System.out.println(1);
        }
        if (n > 16)
            System.out.println(3);


        scanner.close();

    }

}
