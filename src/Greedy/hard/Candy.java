package Greedy.hard;

public class Candy {
    public class Solution {
        //prefix and suffix sum
        //Two Array Solution where we scan 2 time from left and from right then we compare both
        // right and left values at each index to get our answer
        //public class Solution {
//     public int candy(int[] ratings) {
//         int sum = 0;
//         int[] left2right = new int[ratings.length];
//         int[] right2left = new int[ratings.length];
//         Arrays.fill(left2right, 1);
//         Arrays.fill(right2left, 1);
//         for (int i = 1; i < ratings.length; i++) {
//             if (ratings[i] > ratings[i - 1]) {
//                 left2right[i] = left2right[i - 1] + 1;
//             }
//         }
//         for (int i = ratings.length - 2; i >= 0; i--) {
//             if (ratings[i] > ratings[i + 1]) {
//                 right2left[i] = right2left[i + 1] + 1;
//             }
//         }
//         for (int i = 0; i < ratings.length; i++) {
//             sum += Math.max(left2right[i], right2left[i]);
//         }
//         return sum;
//     }
// }
        //arithmetic sequence summation with d=1
        public int count(int n) {
            return (n * (n + 1)) / 2;
        }
        public int candy(int[] ratings) {
            if (ratings.length <= 1) {
                return ratings.length;
            }
            int candies = 0;
            int up = 0;
            int down = 0;
            int oldSlope = 0;
            for (int i = 1; i < ratings.length; i++) {
                int newSlope = Integer.compare(ratings[i], ratings[i - 1]);
                //this here indicates that there is some variation in slope, so we will start counting ups and down again
                //from here after
                //(oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0) we are using those down peaks
                // which are below as our restarting point ... we can also do same with UPpeaks
                //
                if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                    candies += count(up) + count(down) + Math.max(up, down);
                    //Max(Up,Down) is used here
                    up = 0;
                    down = 0;
                }
                if (newSlope > 0) {
                    up++;
                } else if (newSlope < 0) {
                    down++;
                } else {
                    candies++;
                }

                oldSlope = newSlope;
            }
            candies += count(up) + count(down) + Math.max(up, down) + 1;
            return candies;
        }
    }
}
