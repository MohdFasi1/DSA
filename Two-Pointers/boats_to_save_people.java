LeetCode#881: https://leetcode.com/problems/boats-to-save-people/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /**
         * sort people to apply two pointers.
         * Initialize a varible to count the boats.
         * use two pointers, one at start(l) and other at end(r).
         */
        Arrays.sort(people);
        int count = 0;
        int l = 0;
        int r = people.length - 1;

        while(l<=r){
            // if the sum of weights of 2 people (those at pointers l & r) is less or equal to limit, place them in a boat, ie, increase count by 1. 
            if(people[l]+people[r]<=limit){
                l++;
                r--;
            }
            // if sum of weight is more ,place the person at pointer at r in the boat 
            else r--;
            count++;
        }
        return count;
    }
}

// Time Complexity -> O(NlogN) + O(N) = O(NlogN)
// Space Complexity -> O(1)