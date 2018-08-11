import java.util.Collections;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String s1 = new String("1") + new String("2");
        String s2 = "12";
        s1.intern();
        System.out.println(s1 == s2);


        //不能忽略精度的问题
        double d1 = 5.232;
        double d2 = 5.23;

        if (d1 == d2) {
            System.out.println("Yes");
        }
        System.out.println(a);
        fun();


    }

    private static final int a = 1;

    private static final void fun() {
        System.out.println("123");
    }
}
