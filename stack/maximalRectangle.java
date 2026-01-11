//LeetCode#85: https://leetcode.com/problems/maximal-rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        // use a strictly increasing monotonic stack. this soloution uses logic of largest rectangle in histogram.
        Deque<Integer> stack;
        /**
         * use an array to store heights of the rectangle.
         * add the height(matrix[i][j]) of the current row to the previous height in this array, if it is 1.
         * else reset the height to 0.
         * 
         * now perform largest rectangle in histogram on each row. 
         */
        int[] rect = new int[cols];
        int maxCount = 0;
        for(int i = 0; i < rows; i++){
            stack = new ArrayDeque<>();
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    rect[j] += matrix[i][j] - '0';
                }
                else rect[j] = 0;
                while(!stack.isEmpty() && rect[stack.peek()] > rect[j]){
                    int elem = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int right = j;
                    int count = rect[elem] * (right - left -1);
                    maxCount = Math.max(maxCount,count);
                }
                stack.push(j);
                }
            while(!stack.isEmpty()){
                        int elem = stack.pop();
                        int left = stack.isEmpty() ? -1 : stack.peek();
                        int right = cols;
                        int count = rect[elem] * (right - left -1);
                        maxCount = Math.max(maxCount,count);
                    }
        }
        return maxCount;
    }
}

// Time Complexity: O(rows * cols)
// Space Complexity: O(2 * cols)