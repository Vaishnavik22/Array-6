/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*/

// Approach 1: Exhaustive - TLE
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        return helper(prices, -1, 0, 0);
    }
    
    private int helper(int prices[], int prevBuyAmt, int profit, int index) {
        if (index >= prices.length) {
            return profit;
        }
        
        if (prevBuyAmt == -1) { // We need to buy stocks
            int profitWithoutBuying = helper(prices, -1, profit, index + 1);
            int profitAfterBuying = helper(prices, prices[index], profit, index + 1);
            return Math.max(profitWithoutBuying, profitAfterBuying);
            
        } else { // We need to sell the stocks we've bought
            int profitWithoutSelling = helper(prices, prevBuyAmt, profit, index + 1);
            // Incr index by 2 for cooldown
            int profitAfterSelling = helper(prices, -1, profit + (prices[index] - prevBuyAmt), index + 2);
            return Math.max(profitWithoutSelling, profitAfterSelling);
        }
    }
}

// Approach 2 : Approach like house robber
// TC: O(n), SC: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        
        int n = prices.length;
        int buy[] = new int[n];
        int sell[] = new int[n];
        
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0], prices[1] + buy[0]);
       
        for (int i = 2; i < n; ++i) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);
        }
        
        return sell[n - 1];
    }
}
// Approach 3: can space be optimized?
