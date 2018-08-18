package swordoffertest;


public class 打印从1到最大的n位数 {

    public static void main(String[] args) {
        int n = 2;
        printNNum(n);
    }

    private static void printNNum(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        prinCore(number, 0);

    }

    private static void prinCore(char[] number, int digit) {

        if (digit == number.length) {
            printSinglerr(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            prinCore(number, digit + 1);
        }
    }

    private static void printSinglerr(char[] number) {

        boolean flag = true;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '0' && flag) {
                continue;
            }
            else {
                System.out.print(number[i]);
                flag = false;
            }

        }
        System.out.println();
    }


    private static void printArr(char[] number) {
        boolean flag = true;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '0' && flag) {
                continue;
            }
            else {
                System.out.print(number[i]);
                flag = false;
            }


        }
        System.out.println();
    }

}
