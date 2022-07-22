package Arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//the method here is to sort an array then to perform binary search on it using two pointers..
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        if (num == null || num.length == 0)
            return res;

        int n = num.length;

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {

            int target_3 = target - num[i];

            for (int j = i + 1; j < n; j++) {

                int target_2 = target_3 - num[j];

                int front = j + 1;
                int back = n - 1;
//what we do here while keeping those two pointers at same position...

                while (front < back) {

                    int two_sum = num[front] + num[back];
//if the left and right are less than target... then we intend to move more left to get higher sum of those two
                    if (two_sum < target_2) front++;

                    else if (two_sum > target_2) back--;

                    else {

                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);

                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;

                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;

                    }
                }

                // Processing the duplicates of number 2
                while (j + 1 < n && num[j + 1] == num[j]) ++j;
            }
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;

        }


        return res;
    }
        }

