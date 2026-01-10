LeetCode#895: https://leetcode.com/problems/maximum-frequency-stack/

class FreqStack {
    private Map<Integer,Integer> freqCount;
    private List<Deque<Integer>> stacks;

    public FreqStack() {
        /**
         * Intialize a hash map to count frequency of elements and an ArrayList that stores stacks.
         * the indices denotes the frequency and the stacks at the index contains elements with index frequency.
         * Intially add an empty stack to skip index 0.
         */
        freqCount = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new ArrayDeque<>());    
    }
    
    public void push(int val) {
        /**
         * Check the frequency of the val and increment it before pushing it to stack.
         * if theres no index = frequency add a stack to the list of stacks.
         * push the val to the stack at index = frequency.
         */
        int freq = freqCount.getOrDefault(val, 0) + 1;
        freqCount.put(val, freq);
        if(stacks.size() == freq){
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(freq).push(val);
    }
    
    public int pop() {
        /**
         * Take the stack with the maximum frequency from the list of stacks.
         * pop the top value from that stack.
         * if top stack gets empty remove it from the list.
         * and return the value.
         */
        Deque<Integer> topStack = stacks.get(stacks.size() - 1);
        int val = topStack.pop();
        freqCount.put(val, freqCount.get(val) - 1);
        if(topStack.isEmpty()){
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }
}

// Time Complexity: O(1)
// Space Complexity: O(N)