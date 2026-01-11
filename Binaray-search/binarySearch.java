//LeetCode#704: https://leetcode.com/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {
        /**
         * Binarray Search, divides the arra into 2 based on condition. Note: it works only with sorted arrays.
         * Start from ends of the array.
         * find the middle index, and compare the value at middle with target.
         * if it is equal return the index.
         * if its smaller the target will be in right array. else in left array.
         */
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}

// Time Complexity: O(logN)
// Space Complexity: O(1)