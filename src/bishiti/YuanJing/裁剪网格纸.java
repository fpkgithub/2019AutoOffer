package bishiti.YuanJing;

import java.util.Scanner;

/**
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，
 * 若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。
 * 度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。
 * 然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 * 输入描述:
 * 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 * 输出描述:
 * 一行输出最小面积
 * 输入例子:
 * 2
 * 0 0
 * 0 3
 * 输出例子:
 * 9
 */
public class 裁剪网格纸 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
        int size = Math.max(maxX - minX, maxY - minY);
        System.out.println(size * size);
        scanner.close();
    }
}
