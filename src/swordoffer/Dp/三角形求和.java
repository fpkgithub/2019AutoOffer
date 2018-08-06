package swordoffer.Dp;

/**
 * 以数字三角形为例：给出一个数字三角形，从顶部到底部有很多路径，求路径最大和。
 * 如：
 * 7
 * 3   8
 * 8   1   0
 * 2   7   4   4
 * 4   5   2   6   5
 */
public class 三角形求和 {

    static int row = 0;
    static int column = 0;


    public static void main(String[] args) {


        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        row = arr.length;
        column = arr[row - 1].length;
        //朴素DFS
        System.out.println(PuSuDFS(arr, 0, 0));

        //记忆化DFS
        int[][] result = new int[row + 1][column];
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = 0;
            }
        }
        //System.out.println(JiyihuaDFS(arr, 0, 0, result));

        System.out.println(DP(arr, result));

    }

    //result数组空间比三角形大1，全初始化为0，Dp的计算过程是先算三角形的最后一行result[numCount-1][j]，
    // result[i+1][j]从实际意义讲不存在，这里等于1，所以这一行计算结果都是本身，
    // 然后算上一行直到(0,0)，得到问题最终解。
    private static int DP(int[][] arr, int[][] result) {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[i][j] = Math.max(result[i + 1][j], result[i + 1][j + 1]) + arr[i][j];
            }
        }
        return result[0][0];
    }

    private static int JiyihuaDFS(int[][] arr, int x, int y, int[][] result) {

        if (x > arr.length - 1)
            return 0;
        //如果算过，直接取
        if (result[x][y] != -1)
            return result[x][y];
        return result[x][y] = arr[x][y] + Math.max(JiyihuaDFS(arr, x + 1, y, result), JiyihuaDFS(arr, x + 1, y + 1, result));

    }

    private static int PuSuDFS(int[][] arr, int x, int y) {
        if (x > arr.length - 1)
            return 0;
        return arr[x][y] + Math.max(PuSuDFS(arr, x + 1, y), PuSuDFS(arr, x + 1, y + 1));
    }


}
