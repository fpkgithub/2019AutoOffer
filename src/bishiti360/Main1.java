package bishiti360;

import java.util.Scanner;

/**
 * 有一个城市需要建造，给你个矿场的坐标,，问把这么多矿坑全都包进城市的话，城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）
 * <p>
 * Input
 * 第一行为，表示矿场数目
 * 下面为行 每行两个数字，，表示第行表示第个矿场的坐标
 * <p>
 * Output
 * 城市所需最小面积
 * <p>
 * 2
 * 0 0
 * 2 2
 * <p>
 * 4
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int i = 0;
        long xx = 1000000000;
        long xy = 1000000000;
        long dx = 0;
        long dy = 0;

        for (int j = 0; j < N; j++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            xx = Math.min(xx, x);
            xy = Math.min(xy, y);
            dx = Math.max(dx, x);
            dy = Math.max(dy, y);
        }

        long res1 = dx - xx;
        long res2 = dy - xy;
        if (res1 > res2) {
            System.out.println(res1 * res1);
        }
        else {
            System.out.println(res2 * res2);
        }

        scanner.close();
    }
}
