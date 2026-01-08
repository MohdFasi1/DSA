LeetCode#189: https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
        // Mod value of k with length of array to make it lower than length if its higher.
        k %= nums.length;
        /**
         * Reverse the array using 2 pointers
         * this divides the array in 2 where one subarray has last k values(values to rotate)
         * and other has n-k to be appeared at last of the array
         * but they are in reverse order.
         */
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        /**
         * Now Reverse the first subarray (starting from 0 to k)
         */

        l = 0;
        r = k - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        /**
         * then divide the 2nd subarray (starting from k to end of array). Array is now rotated.
         */
        l = k;
        r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}


// Time Complexity: O(N)
// Space Complexity: O(1)