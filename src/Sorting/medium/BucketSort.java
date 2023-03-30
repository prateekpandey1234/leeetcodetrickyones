package Sorting.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {
    class Solution {
        //using bucket sort which was just i think is clever use of data structure , in the bucket sort we create an array with arraylist and indices of that array will denote the count or frequency of our numbers, these number then will be added in that arraylist as per their frequency which will be indices in array
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i : nums){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            List<Integer> bucket[] = new ArrayList[nums.length + 1];

            for(int key : map.keySet()){
                int freq = map.get(key);
                if(bucket[freq] == null){
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }

            int res[] = new int[k];
            int index = 0;
            for(int i = bucket.length - 1; i >= 0; i--){
                if(bucket[i] != null){
                    for(int val : bucket[i]){
                        res[index++] = val;
                        if(index == k) return res;
                    }
                }
            }
            return res;
        }
    }

}
