// LeetCode#84: https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
        // Initialize a stack, this is is strictly increasing monotonic stack.
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        /**
         * for each heights[i] find the previous and next smaller elements.
         * This can be done in linear time in one pass. if the element at the top of stack is larger than current element.
         * we can say that, current element is the next smaller element(right) of element at top of stack, pop it.
         * and next element at the top of stack is previous smaller element(left), just read this, do not pop as this can be previous smaller element of some other element in heights.
         * if the is no previous smaller element, ie stack is empty, keep left = -1.
         * calculate are of rectangle with height and length, length is the distance between previous and next smaller element, ie right - left -1.
         * if the are is larger than maxArea, then update it to maxArea.
         */
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int elem = stack.pop();
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = heights[elem] * (right - left - 1);
                maxArea = Math.max(maxArea,area);
            }
            /**
             * if the element at top of stack is smaller or equal the just add the index to the stack
             * keeping stack helps easy length calculation.
             */
            stack.push(i);
        }
        /**
         * Some of the elements may not have touched, due to missing next smaller element.
         * take an imaginary element (index) at the end of array(length of array) as index for next smaller element.
         * repeat the same here to find maxArea.
         */
        while(!stack.isEmpty()){
            int elem = stack.pop();
            int right = heights.length;
            int left = stack.isEmpty() ? -1 : stack.peek();
            int area = heights[elem] * (right - left - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)