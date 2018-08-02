package swordoffertest;

public class TestException {


    public static int method(int i) throws Exception {
        try {
            return 100 / i;
        } catch (Exception ex) {
            throw new Exception("exception in a Method ");
        } finally {
            System.out.printf("finally ");
        }
    }

    public static void main(String[] args) {

        try {
            method(0);
        } catch (Exception ex) {
            System.out.printf("exception in main ");
        }

        System.out.printf("finished ");//finally exception in main finished Disconnected
    }
}
