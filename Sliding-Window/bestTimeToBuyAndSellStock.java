// LeetCode#121: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        /**
         * Using Sliding window, where start of window is the buy day and end is the sell day.
         * start from first day to buy stock, and second day to sell stock.
         * if the price at end of window is smaller, reset the window and start from this day(end of window).
         * check the profit for each day and return maxProfit.
         */
        int maxProfit = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            int profit = prices[i]-buy;
            maxProfit = Math.max(maxProfit,profit);
            if(buy>prices[i]){
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)