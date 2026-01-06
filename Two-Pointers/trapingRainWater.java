// LeetCode#42: https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        /**
         * Using Two pointers, one at start(l) and other at end(r) of the array.
         * record and monitor the max height prefix to l and max height suffix to r.
         */
        int l = 0, r= height.length - 1;
        int count = 0;
        int maxL = height[l];
        int maxR = height[r];

        while(l<r){
            /**
             * take the smaller of prefix(maxL) and suffix(maxR).
             * move l pointer if prefix is smaller, update the prefix(maxL) if maxL < height[l].
             * move r pointer if sufix is bigger, and update the suffix(MaxR) if maxR < height[r].
             */
            if(maxL <= maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                count+= maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(maxR,height[r]);
                count+= maxR - height[r];
            }
        }
        return count;
    }
}

// Time complexity ->O(N)
// Space complexity -> O(1)