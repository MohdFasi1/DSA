//LeetCode#948 https://leetcode.com/problems/bag-of-tokens

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        /**
         * Sort the array to use 2 pointers.
         * Initialize pointers from both ends of the array.
         * The left side will play face up and right side will play face down.
         * use 2 varibles to store current sum and max sum.
         */
        Arrays.sort(tokens);
        int l=0;
        int r = tokens.length -1;
        int maxScore = 0;
        int currScore = 0;
        while(l<=r){
            /**
             * If theres enough power play faceup,
             * this adds one score and looses token[l] power
             * store the score if its higher than previour maxScore.
             */
            if(power>=tokens[l]){
                currScore++;
                power -=tokens[l];
                l++;
                maxScore = Math.max(maxScore,currScore);
            }
            /**
             * if theres not enough power and atleat 1 score play face down.
             * this adds tokens[r] value to the power, but costs 1 score.
             * no need to update it to maxScore as it will be always lower.
             */
            else if(currScore > 0){
                currScore--;
                power+=tokens[r];
                r--;    
            }
            // if theres not enough power and 0 score then we cannot play either.
            else break;           
        }
        return maxScore;
    }
}

// Time Complexity: O(NlogN) + O(N) = O(NlogN)
// Space Complexity: O(1)