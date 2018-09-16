package bishiti.Huya;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            fun2(scanner.nextLine());
        }
        //fun(list);
        //scanner.close();
    }

    private static void fun2(String str) {
        str = str.replace(" ", "");
        if (str.length() <= 6) {
            System.out.println(str);
        } else if (str.length() <= 14) {
            System.out.println(str.substring(0, 6) + " " + str.substring(6));
        } else if (str.length() <= 18) {
            System.out.println(str.substring(0, 6) + " " + str.substring(6, 14) + " " + str.substring(14));
        }
    }

    //6+8+4
    private static void fun(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).replace(" ", "");
            if (str.length() <= 6) {
                System.out.println(str);
            } else if (str.length() <= 14) {
                System.out.println(str.substring(0, 6) + " " + str.substring(6));
            } else if (str.length() <= 18) {
                System.out.println(str.substring(0, 6) + " " + str.substring(6, 14) + " " + str.substring(14));
            }

        }

    }
}
