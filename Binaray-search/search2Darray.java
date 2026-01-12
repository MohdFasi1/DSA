//LeetCode#74: https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public int findMatrix(int[][] matrix, int target){
        //find the the row in the matrix to search.
        int l = 0;
        int r = matrix.length - 1;
        // perform binary search on first element of each row in the matrix
        while(l <= r){
            int m = l + (r - l) / 2;
            /**
             * if target belongs to larger row, move l towards it (l to mid +1)
             * if target belongs to smaller row, move r t0 mid -1.
             * if target belongs to current row then move pointer l to next row (l to mid + 1), and in next iteration value will be larger so move r to mid - 1,
             * this takes r to row to which the element belongs, return r.
             */
            if(matrix[m][0] <= target) l = m + 1;
            else r = m - 1;
        }
        return r;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int p = findMatrix(matrix, target);

        // if target is smaller than first value (ie, not in matrix) it return -1, handle it right here.
        if (p == -1) return false;

        int l = 0;
        int r = matrix[p].length - 1;
        /**
         * perform binary search on the row.
         */
        while(l <= r){
            int m = l + (r - l) / 2;
            if(matrix[p][m] == target) return true;
            else if(matrix[p][m] < target) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}

// Time complexity : O(log m + log n)
// space Complexity: O(1)