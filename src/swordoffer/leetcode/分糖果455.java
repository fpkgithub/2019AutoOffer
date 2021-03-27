package swordoffer.leetcode;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 * 思路：
 * 已知道一些孩子和一些糖果，每个孩子有需求因子g, 每个糖果有大小g。
 * 当某个糖果的大小s >= 某个孩子的需求因子g时，代表该糖果可以满足该孩子；
 * 当使用这些糖果，最多能满足多少孩子？ 注意：某个孩子最多只能用1个糖果满足
 *
 * 例如：需求因子数组g=[5,10,2,9,15,9], 糖果大小数组 s=[6,1,20,3,8]，为了更明显的判断某个孩子可以被某个糖果满足，对g,s进行排序后观察
 * g=[2,5,9,9,10,15]; s=[1,3,6,8,20]
 *
 * 贪心算法思路：
 * 需求因子数组g=[2,5,9,9,10,15]; 糖果大小数组 s=[1,3,6,8,20]
 * 核心目标：让更多孩子得到满足，有如下规律：
 * 1：某个糖果不能满足某个孩子，则该糖果也一定不能满足需求因子更大的孩子
 *
 * 2：某个孩子可以用更小的糖果满足，就没有必要用更大糖果满足，因为可以保留更大的糖果满足需求因子更大的孩子（贪心）
 *
 * 3：孩子的需求因子更小则更容易被满足，故优先从需求因子小的孩子尝试，可以得到正确的结果
 */
public class 分糖果455 {

    private int findcontentchildren(int[] g, int[] s){

        int child =0;
        int sugar = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (child < g.length && sugar < s.length){

            //如果当前孩子需求得到满足，则下一个孩子
            if(g[child] <= s[sugar]){
                child ++;
            }
            //不管满不满足，都遍历下一个糖果
            sugar ++;
        }
        return child;
    }

    public static void main(String[] args) {
        分糖果455 test = new 分糖果455();
        System.out.println(test.findcontentchildren(new int[]{2,5,9,9,10,15}, new int[]{1,3,6,8,20}));
    }

}
