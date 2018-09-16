package bishiti.DisiFanshi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1 = scanner.next();
        String num2 = scanner.next();
        if (num1.charAt(0) != '0' && num2.charAt(0) != '0') {
            long n1 = Integer.parseInt(num1);
            long n2 = Integer.parseInt(num2);
            long res = n1 * n2;
            System.out.println(res+"");
        }
        scanner.close();
    }
}
