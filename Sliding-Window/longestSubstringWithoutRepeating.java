// LeetCode#3: https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * Hashmap stores last index of the unique characters in the string.
         * use sliding window, increase the size of window to right if character is not seen yet/not in hashmap.
         * if character is seen before decrease the window size from left upto that character,
         * now add current character to the hm(update the index).
         * check the length with maxlength and update maxLength if it is max.
         */
        Map<Character,Integer> hm = new HashMap<>();
        int st = 0;
        int maxLen = 0;

        for(int e = 0; e < s.length(); e++){
            if(hm.containsKey(s.charAt(e))){
                st = Math.max(st, hm.get(s.charAt(e)) + 1);
            }
            hm.put(s.charAt(e), e);
            int len = e - st + 1;
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}
/**
* Time Copmplexity: O(N)
* Space Complexity: O(M) 
*
*              where N = length of string,
                      M = no. of unique characters in string
*/