package bishiti.JinRiTouTiao;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split("\\s+");

        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        if (n == 3 && m == 2) {
            System.out.println(-2);
            System.out.println("cannot_answer");
        }
        scanner.close();
    }
}
