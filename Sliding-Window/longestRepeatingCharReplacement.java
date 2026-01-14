// LeetCode#424: https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        /** 
         * use a hashmap to store count of unique characters in the string.
         * use sliding window, starting from index 0, add count of unique charcters into the hashmap.
         * keep record of highest count of the character in hashmap.
         * check if the the substring is valid, a valid string contains contains same letter and k letters changed to that same letter.
         * valid string can be checked by (length - maxf <= k) where,
         *                  length is the length of substring (r-l+1),
         *                  maxf is the highest frequecy/count of letter in hashmap.
         * 
         * if invalid shrink the window by one untill valid.
         * return max length.  
        */
        Map<Character,Integer> count = new HashMap<>();
        int l = 0;
        int res = 0;
        int maxf = 0;
        for(int r = 0; r<s.length(); r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r),0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while((r-l+1) - maxf > k){
                count.put(s.charAt(l),count.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        } 
        return res;
    }
}

// Time complexity: O(N)
// Space Complexity: O(M)
//             where, N = length of string
//                    M = no. of unique letters in string.