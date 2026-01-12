// LeetCode#981: https://leetcode.com/problems/time-based-key-value-store/

class TimeMap {
    /**
     * initialize a hash map that stores List of pairs.
     * class Pairs store times stamp and value.
     */
    Map<String,List<Pair>> keyMap;
    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        /**
         * get the list from keymap with key, if not intialize a new arraylist
         * create the pair with class Pair, and add it to list.
         * update the list in keymap.
         */
        List<Pair> pairList = keyMap.getOrDefault(key, new ArrayList<>());
        Pair pair = new Pair(timestamp,value);
        pairList.add(pair);
        keyMap.put(key, pairList);
    }
    
    public String get(String key, int timestamp) {
        /**
         * return empty if key not in keyMap.
         * peform binary search on list at key, compare target timestamp with timestamps in list.
         */
        if(!keyMap.containsKey(key)) return "";

        List<Pair> pairList = keyMap.get(key);
        int l = 0;
        int r = pairList.size() - 1;
        String res = "";
        while(l <= r){
            int mid = l + (r - l) / 2;
            Pair pair= pairList.get(mid);

            if(pair.timestamp <= timestamp){
                res = pair.value;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return res;
    }
}


 class Pair{
    public int timestamp;
    public String value;
    Pair(int t, String v){
        this.timestamp = t;
        this.value = v;
    }
 }

/**
 * Time Complexities
 *              get(): O(1)
 *              set(): O(logN)
 * Space Complexity: O(M * N) 
 *              where M = no. of keys
 *                    N = length of list at key
 */