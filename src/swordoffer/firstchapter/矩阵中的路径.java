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
public class 矩阵中的路径
{
    public static void main(String[] args)
    {
        String str = "bfce";
        boolean res = isExist(str);
    }

    //a b t g
    //c f c s
    //j d e h
    //找bfce
    //思路：回溯法

    private static boolean isExist(String str)
    {
        char[] a = str.toCharArray();


        return false;
    }

}
