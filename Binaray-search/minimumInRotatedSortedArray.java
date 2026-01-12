//LeetCode#153: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        /**
         * Consider array as a montain array, max value is the peak and value next to peak is the minimum.
         * Perform binaray search by comparing middle value with value at r.
         * if middle value is bigger than nums[r], may or may not be at peak. move l to m+1.
         * else r to middle.
         * return l, since we will move l to m + 1 when we are at peak. 
        */
        while(l < r){
            int m = l + (r - l)/2;
            if(nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        return nums[l];
    }
}

// Time Complexity: O(logN)
// Space Complexity: O(1)