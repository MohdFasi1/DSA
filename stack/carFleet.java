//LeetCode#853: https://leetcode.com/problems/car-fleet/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        /**
        * create an array to store time required to reach the target by cars.
        * the array is initialized with size target, where index is the position of the car and values are times required by respectve car.
        * some of the values can be 0, these can be skipped.
        * array of size target makes the position is decending order, this simplifies finding fleets wrt to next car as cars cannot over take.
        * so we are guarenteed that, car at nearest position will reach first or in fleet. 
        */
        float[] time = new float[target+1];
        for(int i = 0; i < n; i++){
            /**
             * time can be calculated by:
             * displacement = target - position
             * velocity = speed
             * time = displacement/velocity;
             */
            time[position[i]] = (float)(target - position[i])/speed[i];
        }

        // fleet records the count of fleets and prev records last shorter time.
        int fleet = 0;
        float prev = 0;

        for(int i = target; i >= 0; i--){
            /**
             * skip 0's in time array.
             * if prev is longer, then its in fleet with car next to it.
             * if not its a new fleet, and update prev to time of current car.
            */
            if(time[i] != 0 && prev < time[i]){
                fleet++;
                prev = time[i];
            }
        }
        return fleet;
    }
}

// Time Complexity: O(NlogN)
// Space Complexity: O(N) 