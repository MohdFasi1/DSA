LeetCode#15: https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums, it takes O(NlogN) time
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        /**
         * Using modified 2 pointers approach, where 
         * first pointer(i) moves linearly from index 0 to n-3, leaving last 2 elements.
         * second and third pointers are classic 2 pointers similar to Two sum problem.
         */
        for(int i = 0; i < nums.length - 2; i++){
            //skip duplicate values
            if(i>0 && nums[i] == nums[i-1]) continue;

            /**
             * second pointer(l) starts from i + 1
             * and third pointer starts from end of the array;
             */
            int l = i + 1;
            int r = nums.length - 1;

            while(l<r){
                /* calculate sum of values at i, l and r.
                    if sum = 0 then add values at i, l, and r to result List.
                */
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    // skip duplicate values at l and r and shift l and r.
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                // if sum < 0 move l -> l+1 else r -> r-1;
                else if(sum < 0) l++;
                else r--;
            }
        }
        return result;
    }
}

// Time Complexity -> O(NlogN + N^2) = O(N^2)
// Space Complexity -> O(1) excluding output