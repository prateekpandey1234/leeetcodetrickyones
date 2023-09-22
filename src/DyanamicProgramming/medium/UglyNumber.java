package DyanamicProgramming.medium;

public class UglyNumber {
//brute force approach here we are just genrating all the results
//here we are genrating such that we are multiplying 1 to n  to 2,3,5 and checking
//whether our res in set or not so that we don't genrate undesire value
// public int nthUglyNumber(int n) {
//     HashSet<Integer> set = new HashSet<>();
//     int count = 0;
//     set.add(1);
//     int result = 1;
//     while (count < n) {
//         if (set.contains(result)) {
//             count++;
//             set.add(result * 2);
//             set.add(result * 3);
//             set.add(result * 5);
//         }
//         result++;
//     }
//     return result - 1;
// }
//this brute force is not good enough so what we will do is that we need to limit the genration
//of numbers as by multiplying our minimum number from
//             set.add(result * 2);
//             set.add(result * 3);
//             set.add(result * 5); u
//from this calculation to our next calculation to get feasible answer hence we are using PQ
//can also use TreeSet
//public int nthUglyNumber(int n) {
//     Queue<Long> queue = new PriorityQueue<Long>();
//     int count = 0;
//     long result = 1;
//     queue.add(result);
//     while (count < n) {
//         result = queue.poll();
//         while (!queue.isEmpty() && result == queue.peek()) {
//             queue.poll();
//         }
//         System.out.println(result);
//         count++;
//         queue.offer(result * 2);
//         queue.offer(result * 3);
//         queue.offer(result * 5);
//     }
//     return (int) result;
// }

//Dp solution
//We know that the sequence of ugly numbers is 1, 2, 3, 4, 5, 6, 8, 9....

// All our ugly numbers are 2, 3, 5 generated , so the sequence of ugly numbers can be seen as below.

// 1, 1×2, 1×3, 2×2, 1×5, 2×3, 2×4, 3×3...。

// We can divide the ugly numbers into three groups and multiply them by the ugly number sequence 2, 3, 5.

// 乘 2: 1×2, 2×2, 3×2, 4×2, 5×2, 6×2, 8×2,9×2,…
// 乘 3: 1×3, 2×3, 3×3, 4×3, 5×3, 6×3, 8×3,9×3,…
// 乘 5: 1×5, 2×5, 3×5, 4×5, 5×5, 6×5, 8×5,9×5,…
// Copy
// All we need to do is to combine the above three groups in order.

// For merging ordered arrays, you can use the idea of ​​merging and sorting to use three pointers to find the smallest element in the three groups each time, and then move the pointer backwards.

    // Of course, we didn't know the ugly number sequence at first, we can update the ugly number sequence while using the ugly number sequence.
    class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1; // sequence of ugly numbers
            int index2 = 0, index3 = 0, index5 = 0; // three pointers
            for (int i = 1; i < n; i++) {
                // Choose the smaller of the three
                int factor2 = 2 * ugly[index2];

                int factor3 = 3 * ugly[index3];
                int factor5 = 5 * ugly[index5];
                int min = Math.min(Math.min(factor2, factor3), factor5);
                ugly[i] = min;//Update the sequence of ugly numbers
                //if our number is minimum with a respective factor which means we will need next number in series
                // and that we will get after incrementing the factor to be multiplied with it's prime such to get
                //next number
                if (factor2 == min)
                    index2++;
                if (factor3 == min)
                    index3++;
                if (factor5 == min)
                    index5++;
            }
            return ugly[n - 1];
        }}


}
