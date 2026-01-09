LeetCode#150: https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        // Initialize a stack, this stores the operands.
        Stack<Integer> stack = new Stack<>();
        /**
         * For each string in tokens
         * if string is an operand, push it to stack
         * if string is an operator, then pop 2 elements from stack and perform operation on them.
         * push the value after operation to the stack.
         */
        for(String s: tokens){
            switch(s){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    // the first element popped from stack is second operand as it is reversed.This is crucial, especially for - and /.
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        // return top element of the stack.
        return stack.peek();
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)