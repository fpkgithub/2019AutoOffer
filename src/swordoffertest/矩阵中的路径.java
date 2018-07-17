package swordoffertest;

public class 矩阵中的路径
{
    public static void main(String[] args)
    {
        boolean res = hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray());
        System.out.println(res);  //ture
    }

    private static boolean hasPath(char[] maxtrix, int rows, int cols, char[] str)
    {

        if (maxtrix.length != rows * cols || str.length < 1 || str == null)
            return false;

        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++)
        {
            visited[0] = false;
        }

        int pathLength = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (hasPathCore(maxtrix, rows, cols, str, i, j, visited, pathLength))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] maxtrix, int rows, int cols, char[] str, int row, int col, boolean[] visited, int pathLength)
    {
        if (pathLength == str.length)
            return true;

        boolean hasPath = false;

        //行判断 列判断  是否已经访问  当前字符对比
        if (row >= 0 && col >= 0 && rows > row && cols > col && !visited[row * cols + col] && maxtrix[row * cols + col] == str[pathLength])
        {
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(maxtrix, rows, cols, str, row, col + 1, visited, pathLength)
                    || hasPathCore(maxtrix, rows, cols, str, row, col - 1, visited, pathLength)
                    || hasPathCore(maxtrix, rows, cols, str, row + 1, col, visited, pathLength)
                    || hasPathCore(maxtrix, rows, cols, str, row - 1, col, visited, pathLength);

            //回溯
            if(!hasPath)
            {
                pathLength--;
                visited[row * cols + col] = false;
            }

        }
        return hasPath;
    }
}
