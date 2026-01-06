// LeetCode#11: https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] heights) {
        /**
         * Using two pointers, one points at start(l) and other at end(r)
         */
        int maxAmount = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l<r){
            /**
             * take smaller height of heights at l and r, container can store upto smaller height, else it will overflow.
             * now calculate the distance between points l and r (ie., r - l);
             * now calculate area(amount) with height and distance.
             * and store the amount to maxAmount it is more than existing maxAmount.
             */
            int minHeight = Math.min(heights[l], heights[r]);
            int amount  = minHeight * (r - l);
            maxAmount = Math.max(amount,maxAmount);

            // move pointer with smaller height to left(if r) or right(if l) respectively;
            if(heights[l] <= heights[r]) l++;
            else r--;
        }
        return maxAmount;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(1)