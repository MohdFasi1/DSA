//LeetCode#875: https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int calculateHours(int[] piles, int s){
        int totalhours = 0;
        // calculate total hours requuired to eat all bananas in s/per hour speed.
        for(int i = 0; i< piles.length; i++){
            totalhours += Math.ceil((double)piles[i]/(double)s);
        }
        return totalhours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        /**
         * minimum integer k such that koko can eat all bananas in h hours, lies between 1 to maxvalue in array piles.
         * perform binary search in range 1 to maxValue in piles.
         * calculate hours required to eat all bananas at speed m.
         */
        int l = 1;
        int r = 0;
        for(int p: piles) r = Math.max(r,p);

        while(l<=r){
            int mid = l + (r - l) /2;
            int totalHours = calculateHours(piles, mid);

            if(totalHours > h) l = mid + 1;
            else r = mid - 1; 
        }
        return l;
    }
}

// Time Complexity: O(Nlogn), where N = length of piles and n = max value in piles.
// space Complexity: O(1) 