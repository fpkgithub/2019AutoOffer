package swordoffer.leetcode;

/**
 * 找最优解：
 * 1：考虑特殊情况，当面额等于总金额时，可得到最优解
 * 2：每次寻找小于总金额的面额，dp[i]的最优解=min(dp[i-coins[j]] + 1)  j=coins[j]
 * 题目：
 * 给定不同面额的硬币coins和一个总金额amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class 找零钱 {

    /**
     * 贪心策略：尽量使用大面值的钞票，无法找到最优解，所以使用动态找最优解
     * dp[i]:表示目前金额所需最少的硬币数
     * 当i=0: d(i) = 0
     * 当i=amount: d(i) = min{dp[i-coing[j]]} + 1
     * @param coins [1,5,10]
     * @param amount [18]
     * @return
     */
    private int coinChange(int[] coins, int amount){

        int dp[] = new int[amount+1];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = -1; //初始化dp为-1，用-1标记为不可达
//        }
        dp[0] = 0;//初始边界条件
        //依次计算金额1到amount的最优解
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE-1;//Integer.MAX_VALUE-1是为了防止+1后溢出
            //每个金额i，遍历coins面额
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0){//当前金额>=硬币金额
                    cost = Math.min(dp[i-coins[j]] + 1,cost);
                }
            }
            //一次遍历得到一个最优解，记录到dp中
            dp[i] = cost;
        }
        return dp[amount];
    }

    //https://www.zhihu.com/zvideo/1353397437126639616
    private int coinChange2(int[] coins, int amount){

        //初始化数组dp, 默认值为-1
        int dp[] = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        //金额0的最优解为0
        dp[0] = 0;
        //遍历1到amount的金额，获取最优解
        for (int i = 1; i <= amount ; i++) {
            //对于每个金额i，使用变量j遍历面值coins数组
            for (int j = 0; j < coins.length; j++) {
                //coins[j]在小于等于面值i的时，且金额i-coins[j]有最优值
                if (coins[j] <= i && dp[i-coins[j]] != -1 ) {
                    //如果当前金额还没有计算 或者 当前dp[i]比当前计算的最优解大，则更新dp[i]
                    if (dp[i] == -1 || dp[i] > dp[i -coins[j]] +1){
                        dp[i] = dp[i -coins[j]] + 1;
                    }
                }
            }
        }

        return dp[amount];

    }

    public static void main(String[] args) {
        找零钱 test = new 找零钱();
        int res = test.coinChange(new int[]{1,2,5},11);
        System.out.println(res);
    }

}
