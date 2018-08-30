package swordoffer.fourchapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 57
 */
public class 和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int begin = 1;
        int end = 2;
        while (begin < end) {
            int curSum = (begin + end) * (end - begin + 1) / 2;
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = begin; i <= end; i++) {
                    list.add(i);
                }
                res.add(list);
                begin++;
            }
            else if (curSum < sum) {
                end++;
            }
            else {
                begin++;
            }
        }
        return res;
    }
}
