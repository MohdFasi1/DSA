LeetCode#155: https://leetcode.com/problems/min-stack/

class MinStack {
    /**
     * create 2 private stacks, to be accessible only in class.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        /**
         * Intialize the stacks here to bind them to the object instead of class.
         */
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        /**
         * Push val to the main stack
         * and if stack is empty or the value is smaller or equal to top value of extra stack(minStack), then push the val to the minStack.
         * This make sure only min values are at top.
         */
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) 
            minStack.push(val);
    }
    
    public void pop() {
        /**
         * pop the top value from the main stack.
         * if this value is same as top element of the min Stack, then pop it as well.
         */
        int removed = stack.pop();
        if(removed == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        // return top element at main stack.
        return stack.peek();
    }
    
    public int getMin() {
        // return top element at extra stack(minStack).
        return minStack.peek();
    }
}


// Time Complexity: O(1)
// Space Complexity: O(N)