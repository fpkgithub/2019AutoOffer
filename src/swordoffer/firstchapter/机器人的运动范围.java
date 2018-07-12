package swordoffer.firstchapter;

/**
 * 题目描述:
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。例如，当 k 为 18 时，机器人能够进入方格（35, 37），
 * 因为 3+5+3+7=18。但是，它不能进入方格（35, 38），因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class 机器人的运动范围
{
    public static void main(String[] args)
    {
        /**
         * 解题思路：回溯法
         * （1） 初始化
         * （2） 核心类
         * （3） 判断是否进入了方格和是否大于数位之和
         */

        int res = movingCount(5,10,10);
        System.out.println(res);

    }

    /**
     *
     * @param k 限制条件k
     * @param rows 方格的行数m
     * @param cols 方格的列数n
     * @return
     */
    private static int movingCount(int k, int rows, int cols)
    {
        if (k < 0 || rows <= 0 || cols <= 0)
        {
            return 0;
        }

        //初始化变量
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++)
        {
            visited[i] = false;
        }

        int count = movingCountCore(k, rows, cols, 0, 0, visited);

        return count;
    }

    private static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] visited)
    {
        int count = 0;

        if (check(k, rows, cols, row, col, visited))
        {
            //标志走过了,则遍历其他的
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(k, rows, cols, row - 1, col, visited)
                    + movingCountCore(k, rows, cols, row, col - 1, visited)
                    + movingCountCore(k, rows, cols, row + 1, col, visited)
                    + movingCountCore(k, rows, cols, row, col + 1, visited);
        }

        return count;
    }

    //判断机器人是否进入坐标（row,col）的方格
    private static boolean check(int k, int rows, int cols, int row, int col, boolean[] visited)
    {
        if (row >= 0 && col >= 0 && row < rows && col < cols
                && !visited[row * cols + col]
                && getDigitSum(row) + getDigitSum(col) <= k)
            return true;
        return false;
    }

    //获取数字的数位之和
    private static int getDigitSum(int num)
    {
        int sum = 0;
        while (num > 0)
        {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
