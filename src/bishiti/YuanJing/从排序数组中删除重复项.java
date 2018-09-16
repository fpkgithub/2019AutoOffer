package bishiti.YuanJing;

/**
 * 给你一个有序数组，返回去除重复元素后数组的长度。不允许申请新的空间。
 * 题解方法是双指针，一个指针只记录unique的并且帮助记录长度，一个指针往前找。
 */
public class 从排序数组中删除重复项 {

    public static void main(String[] args) {

        int[] A = {1, 1, 1, 2, 2, 5, 5, 6};
        System.out.println(fun(A));
    }

    //例如：1 2 2 2 3 4 5
    //      1 2 3 4 5 |4 5
    private static int fun(int[] a) {
        if (a.length == 0 || a == null) {
            return 0;
        }
        int len = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1])
                continue;
            a[len++] = a[i];
        }
        return len;
    }
}
