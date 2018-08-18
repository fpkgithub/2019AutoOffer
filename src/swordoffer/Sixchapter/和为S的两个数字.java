package swordoffer.Sixchapter;

import java.util.ArrayList;


public class 和为S的两个数字 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 14};
        int target = 15;
        ArrayList<Integer> res = getSum(nums, target);
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    private static ArrayList<Integer> getSum(int[] nums, int target) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int curSum = nums[i] + nums[j];
            if (curSum == target) {
                list.add(nums[i++]);
                list.add(nums[j--]);
                return list;
            }
            else if (curSum < target) {
                i++;
            }
            else {
                j--;
            }

        }
        return list;
    }
}
