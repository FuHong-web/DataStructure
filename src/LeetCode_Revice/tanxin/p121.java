package LeetCode_Revice.tanxin;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/15 22:13
 * @desc:买卖股票的最佳时机
 */
public class p121 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            buy = Math.min(price,buy);
            profit = Math.max(profit,price - buy);
        }
        return profit;
    }
}
