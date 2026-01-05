// leetcode#238: https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // step 1: Calculate product of prefix for each num in array. 
        int[] prefix = new int[nums.length];
        prefix[0]=1;
        for(int i=1;i<nums.length;i++){
            prefix[i] = nums[i-1]*prefix[i-1];
        }
        // step 2: calculate Suffix of each element and multipy it with prefix, starting from from end of array.
        int suffix = 1;
        for(int i=nums.length-1;i>=0;i--){
            prefix[i]*=suffix;
            suffix*=nums[i];
        }
        return prefix;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)