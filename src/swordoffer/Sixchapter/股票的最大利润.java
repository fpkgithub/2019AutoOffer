package swordoffer.Sixchapter;

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
        return maxProfit;

    }
}
