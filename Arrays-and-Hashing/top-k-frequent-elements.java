// LeetCode#347: https://leetcode.com/problems/top-k-frequent-elements/

// Approach 1: HashMap + MinHeap.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /* step 1: Count Frequency of each element using hashMap.
                    Key -> num[i]
                    Value -> Count
        */
        Map<Integer,Integer> hm = new HashMap<>();
        for(int n: nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        // step 2: Create a minHeap based on frequency.
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)-> a.getValue() - b.getValue());
        /* step 3: mintain heap size = k
                    Add each (number, frequency) pair to the heap
                    If heap size exceeds k, remove the least frequent element
        */
        for (Map.Entry<Integer,Integer> entry: hm.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        //step 4: Extract remaining elements from the heap
        int res[] = new int[k];
        int i =  0;
        while(!minHeap.isEmpty()){
            res[i++] = minHeap.poll().getKey();
        }
        return res;
    }
}