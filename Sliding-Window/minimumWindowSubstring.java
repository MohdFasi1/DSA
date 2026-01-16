// leetCOde#76: https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        /**
         * Initialize 2 hashmaps tcount and window, tCount stores frequency of unique characters in target.
         * window keeps track of frequency of unique characters in substring of s.
         */
        Map<Character,Integer> tCount = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(char c: t.toCharArray()){
            tCount.put(c,tCount.getOrDefault(c, 0)+1);
        }
        int l = 0;
        int have = 0, need = tCount.size();
        int[] res = {-1, -1};
        int minLen = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++){
        /**
         * put the frequency of character at r in the window.
         * if the frequency of character at r in window and tcount are equal, increment have.
         * untill have and need are equal, decrease the freqency of character at l in window.
         * if the frequency of char at l in window less then tcount decrement have.
         * save the minLen, l, r for result.
         */
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);

            if(tCount.containsKey(c) && window.get(c).equals(tCount.get(c))){
                have++;
            }

            while(have == need){
                if(r-l+1 < minLe n){
                    minLen = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                char left = s.charAt(l);
                window.put(left, window.get(left) -1);

                if(tCount.containsKey(left) && window.get(left) < tCount.get(left)){
                    have--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);
    }
}

// Time Complexity: O(M+N);
// Space Complexity: O(M+N)