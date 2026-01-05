// LeetCode#347: https://leetcode.com/problems/top-k-frequent-elements/

// Approach 1: HashMap + MinHeap.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            step 1: Count Frequency of each element using hashMap.
                    Key -> num[i]
                    Value -> Count
        */
        Map<Integer,Integer> hm = new HashMap<>();
        for(int n: nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        /*
            step 2: Create a Bucket of size more than size(nums). 
                    index -> frequency;
                    value -> List<Integer> that stores nums with frequency == index.
        */
        List<Integer>[] bucket = new List[nums.length+1];
        /*
            step 3: for each frequency/unique value 
                        add it to the bucket at index = frequency.
        */
        for(int key:hm.keySet()){
            int frequency = hm.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        
        //step 4: Iterate bucket from end and add k values to result array.
        int res[] = new int[k];
        int counter = 0;

        for(int pos = bucket.length -1; pos >=0 && counter < k; pos--){
            if(bucket[pos] != null){
                for(Integer i: bucket[pos]){
                    res[counter++] = i;
                }
            }
        }
        return res;
    }
}