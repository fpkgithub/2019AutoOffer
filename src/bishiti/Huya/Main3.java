package bishiti.Huya;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(findChar(str));
        scanner.close();
    }

    public static char findChar(String s) {
        char[] ch = s.toCharArray();
        int[] arrCount = new int[58];

        for (int i = 0; i < arrCount.length; i++) {
            arrCount[i] = 0;
        }

        for (int i = 0; ch[i] != '\0'; i++) {
            if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
                int temp = ch[i] - 'A';
                arrCount[temp]++;

                if (arrCount[temp] >= 3) {
                    char c = (char) (temp + 'A');
                    return c;
                }
            }
        }
        return 0;
    }


}