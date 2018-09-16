package bishiti.Xiechen;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        System.out.println(count);
        scanner.close();
    }
}
