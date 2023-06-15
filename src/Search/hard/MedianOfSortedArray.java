package Search.hard;

public class MedianOfSortedArray {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //this question is perfect for observation
            //The basic idea is to partition the two arrays such that elements on the left side of the partitions are smaller
            // or equal to elements on the right side. This partitioning should be done in a way that the number of elements
            // on the left side of both partitions is approximately equal to the number of elements on the right side.

// The key steps in the code are as follows:

// Check the lengths of the arrays nums1 and nums2. If nums1 is larger than nums2, swap the arrays to ensure that nums1 is
// always the smaller array. This simplifies the partitioning process.

// Set the initial boundaries for the binary search. The left pointer starts at 0, and the right pointer starts at the length
// of nums1.

// Calculate the partition points partitionX and partitionY based on the left and right pointers. These partition points divide
// the two arrays into left and right halves.

// Determine the maximum elements (maxLeftX and maxLeftY) on the left side and the minimum elements (minRightX and minRightY) on
// the right side of both partitions.

// Compare the maximum elements on the left side (maxLeftX and maxLeftY) with the minimum elements on the right side (minRightX
// and minRightY) to check if the partitioning is valid. If the maximum of the left elements is smaller than or equal to the
// minimum of the right elements for both arrays, it means we have found the correct partition.

// If the partitioning is valid, check if the total length of the combined arrays is even or odd. If it is even, the median is
// the average of the maximum of the left elements and the minimum of the right elements. If it is odd, the median is the maximum
// of the left elements.

// If the partitioning is not valid, adjust the boundaries for the binary search based on the comparison results. If maxLeftX is
// greater than minRightY, it means we need to move the partition towards the left in nums1 to decrease the maximum element.
// Otherwise, we need to move the partition towards the right in nums1 to increase the maximum element.

// Repeat the binary search process until the correct partition is found or the boundaries converge.

            int m = nums1.length;
            int n = nums2.length;

            // Ensure nums1 is the smaller array
            if (m > n) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
                int tempSize = m;
                m = n;
                n = tempSize;
            }

            int left = 0;
            int right = m;
            int halfLength = (m + n + 1) / 2;

            while (left <= right) {
                // Find the partition points for both arrays
                int partitionX = (left + right) / 2;
                int partitionY = halfLength - partitionX;

                // Calculate the maximum and minimum elements on the left and right sides of the partitions
                int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
                int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
                int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
                int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

                // Check if the partitioning is valid
                if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                    if ((m + n) % 2 == 0) {
                        // If the total length of combined arrays is even, return the average of the two middle elements
                        double leftMax = Math.max(maxLeftX, maxLeftY);
                        double rightMin = Math.min(minRightX, minRightY);
                        return (leftMax + rightMin) / 2.0;
                    } else {
                        // If the total length is odd, return the maximum element from the left side
                        return Math.max(maxLeftX, maxLeftY);
                    }
                } else if (maxLeftX > minRightY) {
                    // If maxLeftX is greater than minRightY, move the partition towards the left in nums1
                    right = partitionX - 1;
                } else {
                    // If maxLeftY is greater than minRightX, move the partition towards the right in nums1
                    left = partitionX + 1;
                }
            }


            return 0.0;
        }
    }

}
