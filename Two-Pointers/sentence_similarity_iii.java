LeetCode#1813: https://leetcode.com/problems/sentence-similarity-iii/

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        //split the sentences to arrays of words
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        
        // Match from start.
        int i = 0;
        while(i<s1.length && i<s2.length && s1[i].equals(s2[i])) i++;

        // Match from end.
        int j = 0;
        while(j<s1.length-i && j<s2.length-i && s1[s1.length-1-j].equals(s2[s2.length-1-j])) j++;

        // check if sum of i and j = smaller of lengths of s1 and s2.
        return i+j == Math.min(s1.length,s2.length);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)