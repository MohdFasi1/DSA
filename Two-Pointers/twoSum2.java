// LeetCode#167: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Using two pointers, one at start(l) and other at end(r) of the array.
        int l = 0;
        int r = numbers.length -1;
        
        while(l < r){
            /*
                caluclate sum of values at l and r pointers.
                if sum = target return l+1 & r+1 (1-indexed array)
                if sum > target, move r to r-1,
                if sum < target move l to l+1.  
            */
            int sum = numbers[l] + numbers[r];
            if(sum == target) return new int[]{l+1,r+1};
            else if(sum > target) r--;
            else l++;
        }
        // this return is unreachable
        return null;
    }
}

// Time Complexity -> O(n)
// space Complexity -> O(1)