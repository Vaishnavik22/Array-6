/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        int minStockPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; ++i) {
            minStockPrice = Math.min(minStockPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minStockPrice);
        }
        
        return maxProfit;
    }
}