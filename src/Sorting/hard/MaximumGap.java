package Sorting.hard;

import java.util.Arrays;

public class MaximumGap {
    // this question is based on bucket sort in which we group the elements of array into different buckets with their range of
    // values , these buckets are then internally sorted using other algos like insertion sort , for this question we don't need
    // sorting of each element but we need to compare max element of ith bucket and minimum of i+1 th bucket which can easily give
    // us our maximum succesive difference ,    so why do we think that max gap will occur in two different buckets  ,As there is
    // n-1 gaps with total sum of  (max-min) value ,which means if we add up all the gaps they will be max-min , meaning every
    // gap will be more than (max-min)/(n-1) value , even if assume gap is 1 we can check this case , so we will make bucketsize
    // of (max-min)/(n-1) which will allow us to look into different buckets without internally sorting the bucket elements
    public int maximumGap(int[] nums) {
        int min = nums[0], max = nums[0], n = nums.length;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        if (min == max) return 0; // All elements are the same
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] minBucket = new int[n];//creating our buckets as these array values will point at bucket size
        int[] maxBucket = new int[n];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int x : nums) {
            int idx = (x - min) / bucketSize;//this idx here will use to decide in which bucket our current element i goes
            //here we will point to max and min values of each bucket using our arrays
            minBucket[idx] = Math.min(x, minBucket[idx]);
            maxBucket[idx] = Math.max(x, maxBucket[idx]);
        }
        int maxGap = bucketSize; // Maximum gap is always greater or equal to bucketSize
        int previous = maxBucket[0]; // We always have 0th bucket
        for (int i = 1; i < n; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue; // Skip empty bucket
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }
        return maxGap;
    }
}
