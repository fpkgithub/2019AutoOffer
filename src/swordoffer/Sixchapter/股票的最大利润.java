package swordoffer.Sixchapter;

import java.util.LinkedHashMap;

/**
 * 面试题63：股票的最大利润
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
 * 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
 * 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
 * 收获最大的利润11。
 */
public class 股票的最大利润 {
    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(getMaxProfit(prices));

    }

    //求数对之差的最大值
    public static int getMaxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        System.out.println(minPrice);
        return maxProfit;

    }
}
