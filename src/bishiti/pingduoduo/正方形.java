package bishiti.pingduoduo;

public class 正方形 {

    public static void main(String[] args) {

        printMatrix("abcdefghijklmnopqrst");
        printMatrix("abcdefgh");
        printMatrix("abcd");

    }

    private static void printMatrix(String str) {

        int strLen = str.length();
        if (strLen % 4 != 0)
            return;
        int k = strLen / 4 + 1;
        int column = k;
        int row = column - 2;

        String firstLine = str.substring(0, column);
        System.out.println(firstLine);

        int leftIndex = strLen - 1;
        int rightIndex = column;
        for (int i = 0; i < row; i++) {

            System.out.print(str.charAt(leftIndex--));
            for (int j = 0; j < row; j++) {
                System.out.print(" ");
            }
            System.out.println(str.charAt(rightIndex++));
        }

        String lastLine = str.substring(column + row, strLen - row);
        StringBuffer reverseLastLine = new StringBuffer(lastLine);
        System.out.println(reverseLastLine.reverse());
        System.out.println();
    }
}
