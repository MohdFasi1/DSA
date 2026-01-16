// LeetCode#239: https://leetcode.com/problems/sliding-window-maximum/

/**
 * find the maximum in the sliding wondow of size k,
 * use a double ended queue(deque) as a strictly decreasing monotonic stack, so the max value will always be in bottom.
 * once reached k-1 (sliding wind0ow size is now k), add bottomm value in the stack to res array.
 * as the window moves forward, remove the last index(r-k+1) from stack.
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int r = 0; r<nums.length; r++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[r]){
                stack.pop();
            }
            stack.push(r);

            if(r>=k-1){
                res[r-k+1] = nums[stack.getLast()];
            }

            if(r-k+1 == stack.getLast()){
                stack.removeLast();
            }
        }
        return res;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(K)