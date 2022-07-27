/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
TC: O(n)
SC: O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        // Min(buy1, prices[i])
        int buy1 = Integer.MAX_VALUE;
        // Min(buy2, prices[i])
        int buy2 = Integer.MAX_VALUE;
        // Profit with just one transaction
        int profit1 = 0;
        // Profit with two transactions at max. Will have the answer.
        int profit2 = 0;
        
        for (int i = 0; i < prices.length; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - buy2);
        }
        
        return profit2;
    }
}