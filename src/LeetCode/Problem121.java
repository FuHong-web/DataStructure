package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/12 15:39
 * @desc:力扣第121题（动态规划）
 * 总结一下思路就是：如果第i天卖出股票，则最大利润为(该天的股价-前面天数中最小的股价)，
 * 然后与已知的最大利润比较，如果大于则更新当前最大利润的值
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int cost=Integer.MAX_VALUE;
        int profit=0;
        for (int price : prices) {
            cost=Math.min(cost,price);//不断找最小的买入价格
            profit=Math.max(profit,price-cost);//不断更新最大利润
        }
        return profit;
    }
}
