// LeetCode#18: https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Sort the array to use two pointer approach.
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // Place a pointer at start(i), this moves from 0 to length - 3(skip last 3 for other pointers).
        for(int i = 0; i < n - 3; i++){
            /**
             * Skip duplicate values.
             * if previous value = current value of nums at i, skip this
             * start second pointer next to i, untill length -2 (skip last 2)
             */
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < n - 2; j++){
                // Skip duplicate same as i for j.
                if(nums[j] == nums[j-1] && j!=i+1) continue;
                int l = j + 1;
                int r = n-1;
                /**
                 * Start 2 pointers one from position next to j and other at end of array.
                 * These moves conditionally towards each other.
                 */
                while(l < r){
                    /**
                     * Calculate sum of values at i, j, l and r.
                     * Note: add it one by one to avoid Larger integer values as addition of large integer values cannot be stored in int variable.
                     */
                    long sum = nums[i];
                    sum+=nums[j];
                    sum+=nums[l];
                    sum+=nums[r];

                    // If sum = target add values at i, j, l and r to result in a List.
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        // skip duplicate values at l and r
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                    // if target is smaller move pointer l towards r else move r towards l.
                    else if(sum < target) l++;
                    else r--;
                }
            }
        }
        return result;
    }
}
/*
    Time Complexity: O(NlogN) + O(N^3)
    space Complexity: O(1) excluding output
                 else O(k) where k = no. of unique quadruplets. 
*/