package swordoffer.Thirdchapter;

import java.util.ArrayList;

/**
 * 面试题29：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class 顺时针打印矩阵
{
    public static void main(String[] args)
    {
        /*
        1    2    3    4
        5    6    7    8
        9    10   11   12
        13   14   15   16
        */
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> res = printMatrix(arr);
        for (Integer val : res)
        {
            System.out.print(val + " ");
        }
    }

    //考虑的情况有：只有一行 只有一列
    private static ArrayList<Integer> printMatrix(int[][] matrix)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2)
        {
            //左到右
            for (int i = c1; i <= c2; i++)
            {
                list.add(matrix[r1][i]);
            }
            //上到下
            for (int i = r1 + 1; i <= r2; i++)
            {
                list.add(matrix[i][c2]);
            }

            //还有行 过滤
            if (r1 != r2)
            {
                //右到左
                for (int i = c2 - 1; i >= c1; i--)
                {
                    list.add(matrix[r2][i]);
                }
            }
            //还有列
            if (c1 != c2)
            {
                for (int i = r2 - 1; i > r1; i--)
                {
                    list.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;

        }
        return list;
    }
}
