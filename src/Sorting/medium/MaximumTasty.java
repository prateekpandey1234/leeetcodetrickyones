package Sorting.medium;

import java.util.Arrays;

public class MaximumTasty {
    class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int maxGap = price[price.length - 1] - price[0]; //array is sorted this will give the maximum difference b/w max and min value
            int minGap = 0; //obviously minimum gap between the highest and lowerst is 0
            int ans = 0;
            //in this method we are taking our gap as value to be searched
            while(minGap<= maxGap){
                int midGap = minGap + (maxGap - minGap) / 2; // get the mid gap in the price
                if(help(price , midGap , k)){ // use a helper function which returns true of false . I will explain below why we use that here
                    ans = midGap; // when ans = midGap , it means ans having the minimum gap because thats only returned from the helper function. Now check for others
                    minGap = midGap + 1;
                }else {
                    maxGap = midGap - 1; //ans doesnt have the minimum gap so check left of the array becasue there only less value price.
                }
            }
            return ans; // return the ans
        }
        //we are here checking whether we got an sequence of candies of k
        boolean help(int[] price , int gapPrice , int k ){  // so basic idea of using this helper function to decide when we are getting the minimum gap between two prices inside the array.
            int count = 1;  // this if for counting . Starts from 1 becasue price[0] is the minimum and we are starting from i = 1.
            int lastMin = price[0];

            for(int i = 1 ; i < price.length ; i++){
                if(price[i] - lastMin >= gapPrice){ // now count for gaps greater than our mid gap
                    count++;
                    lastMin = price[i];
                }
            }
            return count >= k; // if count exeeds the k then its true otherwise false
        }
    }
}
