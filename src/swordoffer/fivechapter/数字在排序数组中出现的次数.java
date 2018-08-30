package swordoffer.fivechapter;

public class 数字在排序数组中出现的次数 {

    public int GetNumberOfK(int[] array, int k) {

        if (array.length == 0 && array == null)
            return 0;

        int[] res = getIndex(array, 0, array.length - 1, k);
        if (res[0] != -1 && res[1] != -1) {
            return res[1] - res[0] + 1;
        }
        return 0;

    }

    private int[] getIndex(int[] array, int start, int end, int k) {

        int res[] = {-1, -1};
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] < k) {
                start = mid + 1;
            }
            else if (array[mid] > k) {
                end = mid - 1;
            }
            else {
                int mid1 = mid;
                int mid2 = mid;
                while (mid1 <= end && array[mid1] == k) {
                    mid1++;
                }
                while (mid2 >= start && array[mid2] == k) {
                    mid2--;
                }
                res[0] = mid1;
                res[1] = mid2;
                return res;
            }
            mid = (start + end) >> 1;
        }
        return res;
    }
}
