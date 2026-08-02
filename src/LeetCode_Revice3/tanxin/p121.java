package LeetCode_Revice3.tanxin;
/*买卖股票的最佳时机*/
public class p121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }else {
                Math.max(maxProfit,price - maxProfit);
            }
        }
        return maxProfit;
    }
}
