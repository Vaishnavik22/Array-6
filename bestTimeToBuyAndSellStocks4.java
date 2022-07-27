/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
TC: O(nk)
SC: O(k)
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0)
            return 0;
        
        int buy[] = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int profit[] = new int[k];
        
        for (int i = 0; i < prices.length; ++i) {
            for (int j = 0; j < k; ++j) {
                if (j == 0) {
                    buy[j] = Math.min(buy[j], prices[i]);
                } else {
                    buy[j] = Math.min(buy[j], prices[i] - profit[j - 1]);
                }
                profit[j] = Math.max(profit[j], prices[i] - buy[j]);
            }
        }
        
        return profit[k-1];
    }
}

// We should be able to do the same thing with just 2 vriables as well n