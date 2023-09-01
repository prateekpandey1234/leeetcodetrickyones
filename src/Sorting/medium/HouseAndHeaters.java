package Sorting.medium;

import java.util.Arrays;

public class HouseAndHeaters {
    class Solution {
        //The difficulty of this problem is to understand Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house
// Let's us understand this with a example:
// houses: 1, 2, 3, 4
// heaters: 1, 4
// For house 1, heater 1 is closer to it than heater 4, so we don't move i to i + 1.
// For house 2, it is same. heater 1 is closer.
// For house 3, it is clear that heater 1 no longer closer, so we move i to i + 1.
// For house 4, continue....

        // The idea here is we move the heater to rightward in case it is closer to the given house.
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int j=0,k=0;
            int ans=0;
            for(int i=0;i<houses.length;i++ ){
                while(j<heaters.length-1 && Math.abs(heaters[j]-houses[i])>=Math.abs(heaters[j+1]-houses[i]))j++;
                ans=Math.max(ans,Math.abs(houses[i]-heaters[j]));
            }
            return ans;
        }
        //public int findRadius(int[] houses, int[] heaters) {
        //     Arrays.sort(heaters);
        //     int result = Integer.MIN_VALUE;

        //     for (int house : houses) {
        //         //we are finding the nearest heater to out current house using binary search inbuilt method
        //         int index = Arrays.binarySearch(heaters, house);
        //         if (index < 0) {
        //             index = -(index + 1);//returned index can be negative
        //         }
        //         //this index we found will now be used to find the nearest heater to house as there may be
        //         //another heater on either side of house
        //         int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
        //         int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

        //         result = Math.max(result, Math.min(dist1, dist2));
        //     }

        //     return result;
        // }
    }
}
