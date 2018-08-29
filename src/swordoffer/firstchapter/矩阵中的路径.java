package swordoffer.firstchapter;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * A B T G
 * C F C S
 * J D E H
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        //ABCE  //ABCCED
        //SFCS
        //ADEE
        boolean res = hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray());
        System.out.println(res);  //ture

        //ABCE  //SEE
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "SEE".toCharArray()));// true
    }

    //a b t g
    //c f c s
    //j d e h
    //找bfce
    //思路：回溯法

    /**
     * 解题思路：https://www.cnblogs.com/mthoutai/p/6991118.html
     * 这是一个能够用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。假设矩阵中某个格子的字符为ch，那么这个格子不可能处在路径上的第i个位置。
     * 假设路径上的第i个字符不是ch。那么这个格子不可能处在路径上的第i个位置。假设路径上的第i个字符正好是ch。那么往相邻的格子寻找路径上的第i+1个字符。
     * 除在矩阵边界上的格子之外，其它格子都有4个相邻的格子。反复这个过程知道路径上的全部字符都在矩阵中找到相应的位置。
     * 因为回朔法的递归特性，路径能够被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后。在与第n个字符相应的格子的周围都没有找到第n+1个字符。
     * 这个时候仅仅要在路径上回到第n-1个字符。又一次定位第n个字符。
     * 因为路径不能反复进入矩阵的格子。还须要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。
     * 当矩阵中坐标为（row,col）的格子和路径字符串中下标为pathLength的字符一样时。
     * 从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下标为pathLength+1的字符。
     * 假设4个相邻的格子都没有匹配字符串中下标为pathLength+1的字符，表明当前路径字符串中下标为pathLength的字符在矩阵中的定位不对，
     * 我们须要回到前一个字符(pathLength-1)，然后又一次定位。
     * 一直反复这个过程，直到路径字符串上全部字符都在矩阵中找到合适的位置
     */


    /**
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜素的字符串
     * @return 是否找到true是。false否
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //参数校验
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1)
            return false;

        //初始化变量
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        //记录结果的数组
        int pathLength = 0;
        //以每个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hashPathCore(matrix, rows, cols, str, visited, i, j, pathLength))
                    return true;
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到
     */
    private static boolean hashPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int pathLength) {
        if (pathLength == str.length)
            return true;

        boolean hasPath = false;

        //推断位置是否合法
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            pathLength++;

            //按左上右下进行回溯
            hasPath = hashPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength) || hashPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength) || hashPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength) || hashPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);
            //回溯
            if (!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}


