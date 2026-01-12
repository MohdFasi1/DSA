// LeetCode#33: https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        /**
         * find the minimum in the rotated sorted array. divide the index into 2 sorted arrays using index of minimum value (pivot).
         * decide which subarray to search by comparing target with last elem in array.
         * if last elem is smaller than target, then search in left sub array (0 to pivot).
         * else search in right sub array (pivot to n)
         */
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        int pivot = l;
        r = nums.length - 1;
        if(target <= nums[r]){
            l = pivot;
        }
        else{
            l = 0;
            r = pivot - 1;
        }
    while(l <= r){
            int m = l + (r - l) /2;
            if(nums[m] == target) return m;
            else if(target > nums[m]) l = m + 1;
            else r =m - 1;
        }
        return -1;
    }
}

// Time Complexity: O(logN)
// Space Complexity: O(1)