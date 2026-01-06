// LeetCode#128: https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        // Step 1: create Hash set and add nums to remove duplicates.
        Set<Integer> numSet = new HashSet<>();
        for(int i: nums){
            numSet.add(i);
        }

        int longest = 0;
        /*
            step 2: For each num in numSet check if num-1 exist
                    if num-1 does not exist, its start of sequence.
        */
        for(int n: numSet){
            if(!numSet.contains(n-1)){
                int length = 0;
                /*
                    step 3: For each sequence (start of sequence) count the consecutive values.
                            consecutive value is (start of sequence) n + length(in range 0->end of sequence)
                */
                while(numSet.contains(n+length)){
                    length++;
                }
                // Step 4: compare longest with current length
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}