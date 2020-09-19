package arrays.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock_121 {

    // first 2 lines could be replaces if minPrice = Integer.MAX_VALUE
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0, minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice  = Math.min(minPrice,  prices[i]);
        }
        return maxProfit;
    }

}
