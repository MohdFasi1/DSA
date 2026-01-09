LeetCode#739: https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initialize result array and a stack.
        int n = temperatures.length;
        int result[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        /**
         * For each temperature in temperatures, compare it ith top value of stack.
         * if temperature at top of stack is less than current temperature, pop the index from stack and caluclate distance (no of days between them) with current index and index at top of stack.
         * Store this in result array.
         */
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int idx = stack.pop();
                result[idx] = i -idx;
            }
            // push the current index into the stack.
            stack.push(i);
        }
        return result;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)