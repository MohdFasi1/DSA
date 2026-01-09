LeetCode#20: https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        //initializ a stack object
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            /**
             * push opening parentheses in the stack
             */
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else{
                // if ch is closing parentheses and stack is empty retrun false
                if(stack.isEmpty()) return false;
                
                /**
                 * if ch is a closing parentheses, check if the top element of the stack is equivalent opening parentheses.
                 * if not return false.
                 */
                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                   (ch == ']' && top != '[') ||
                   (ch == '}' && top != '{' ))
                   return false;
            }
        }
        // At the end stack should be empty to be valid.
        return stack.isEmpty();
    }
}

// Time Complexity: O(N)
// Space complexity: O(N)