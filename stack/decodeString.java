// LeetCode#394: https://leetcode.com/problems/decode-string/

class Solution {
    public String decodeString(String s) {
        /**
         * Initialize 2 stacks, one records strings, and other records repeatation times.
         * maintain 2 vars to record current repeat times and encoded string.
         */
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        StringBuilder currStr = new StringBuilder();
        int reps = 0;
        /**
         * if char is a digit update reps = reps * 10 + digit.
         * if char is a letter append it to current string(currStr).
         * if char is ']' then push current repeatation time(reps) and current stringt to array. and reset them.
         * if char is ']' then store currStr in a temporary(temp) variable, pop top elements from numStack and strStack and store them in reps and currString respectively.
         * now append temp to currStr for reps time.
         */
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                reps *= 10;
                reps += s.charAt(i) - '0';
            }
            else if(s.charAt(i) == '['){
                strStack.push(currStr.toString());
                numStack.push(reps);
                currStr = new StringBuilder();
                reps = 0;
            }
            else if(s.charAt(i) == ']'){
                reps = numStack.pop();
                String temp = currStr.toString();
                currStr = new StringBuilder(strStack.pop());
                while(reps > 0){
                    currStr.append(temp);
                    reps--;
                }
            }
            else currStr.append(s.charAt(i));
        }
        return currStr.toString();
    }
}

// Time Complexity: O(N + n) 
// Space Complexity: O(N + n)
//             where N = length of input and n = length of output