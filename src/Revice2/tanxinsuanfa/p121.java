package Revice2.tanxinsuanfa;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/27 23:03
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
