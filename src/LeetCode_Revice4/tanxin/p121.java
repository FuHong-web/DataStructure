package LeetCode_Revice4.tanxin;
/*买卖股票得最佳时机*/
public class p121 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            cost = Math.min(cost,price);
            maxProfit = Math.max(maxProfit,price - cost);
        }

        return maxProfit;
    }
}
