

import BinaryTree.TreeNode;
import Graph.easy.DisjointSet;
import HashTables.HashTable;
import LinkedList.easy.ListNode;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Practice {

    public static void main(String[] args) {
        System.out.println(Math.pow(2,31)>Integer.MAX_VALUE);

    }


        //prefix sum and sorting method
        public long minCost1(int[] nums, int[] cost) {
            // Sort integers by values.
            int n = nums.length;
            int[][] numsAndCost = new int[n][2];
            for (int i = 0; i < n; ++i) {
                numsAndCost[i][0] = nums[i];
                numsAndCost[i][1] = cost[i];
            }
            Arrays.sort(numsAndCost, (a, b) -> a[0] - b[0]);

            // Get the prefix sum array of the costs.
            long[] prefixCost = new long[n];
            prefixCost[0] = numsAndCost[0][1];
            for (int i = 1; i < n; ++i)
                prefixCost[i] = numsAndCost[i][1] + prefixCost[i - 1];

            // Then we try every integer nums[i] and make every element equals nums[i],
            // Start with nums[0]
            long totalCost = 0l;
            for (int i = 1; i < n; ++i)
                totalCost += (long) numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
            long answer = totalCost;

            // Then we try nums[1], nums[2] and so on. The cost difference is made by the change of
            // two parts: 1. prefix sum of costs. 2. suffix sum of costs.
            // During the iteration, record the minimum cost we have met.
            for (int i = 1; i < n; ++i) {
                int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
                totalCost += prefixCost[i - 1] * gap;
                totalCost -= (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
                answer = Math.min(answer, totalCost);
            }

            return answer;
        }

    //binary search way
    // Get the cost of making every element equals base.
    private long getCost(int[] nums, int[] cost, int base) {
        long result = 0L;
        for (int i = 0; i < nums.length; ++i)
            result += 1L * Math.abs(nums[i] - base) * cost[i];
        return result;
    }

    public long minCost(int[] nums, int[] cost) {
        // Initialize the left and the right boundary of the binary search.
        int left = 1000001, right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        long answer = getCost(nums, cost, nums[0]);

        // As shown in the previous picture, if F(mid) > F(mid + 1), then the minimum
        // is to the right of mid, otherwise, the minimum is to the left of mid.
        while (left < right) {
            int mid = (right + left) / 2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            answer = Math.min(cost1, cost2);

            if (cost1 > cost2)
                left = mid + 1;
            else
                right = mid;
        }
        return answer;
    }




}