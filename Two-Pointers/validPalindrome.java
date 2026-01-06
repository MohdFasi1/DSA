// LeetCode#125: https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        /*
            using two pointers: one at Start(l) and other at end(r) of string.
         */
        int l = 0, r = s.length() -1;

        while(l < r){
            /*
                Skip non-alphanumeric characters.
                Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
            */
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            /*
                Compare alphanumeric Charcters at left pointer(l) and right pointer(r).
                if mismatch return false.
            */
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            
            l++;
            r--;
        }
        return true;
    }
}

// Time Complexity -> O(n);
// Space Complexity -> O(1);