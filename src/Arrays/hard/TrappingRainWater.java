package Arrays.hard;
//Explanation
//    As we know that the water will be stored only if there is a valley, with valley I mean that for an index there should be a wall to the left as well as to right that is greater or equal to the height at that index, then it will be able to store water equal to it's height subtracted from the minimum out of left and right walls. (try drawing it on paper for better clarity).
//
//    So in this approach what I did was for every index I calculated the left max and right max and updated sum by this expression.
//            sum += Math.min(left, right) - height[i]
public class TrappingRainWater {public int trapBrute(int[] height) {
    int n = height.length;
    if(n <= 2) return 0;
    int sum = 0;
    for(int i = 0; i < n; i++) {
        int j = i, left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        while(j >= 0) {
            left = Math.max(left, height[j]);
            j--;
        }
        j = i;
        while(j < n) {
            right = Math.max(right, height[j]);
            j++;
        }
        sum += Math.min(left, right) - height[i];
    }

    return sum;
}
//prefix sum same as above
    public int trapPrefix(int[] height) {
        int n = height.length;
        if(n <= 2) return 0;
        int sum = 0;
        // store maximum to the left
        int[] pre = new int[n];
        pre[0] = height[0];
        for(int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i-1], height[i]);
        }
        // store maximum to the right
        int[] suff = new int[n];
        suff[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            suff[i] = Math.max(suff[i+1], height[i]);
        }
        for(int i = 0; i < n; i++) {
            sum += Math.min(pre[i], suff[i]) - height[i];
        }
        return sum;
    }
//two pointer method
//    Explanation
//    In this we will use two pointers l and r for traversing the array, and leftmax and rightmax for storing the maximum to the left and to the right.
//
//    One thing needs to be very clear that we can add water to our sum only when there is a valley.
//            So while traversing if we find that height[l] is less than or equal to height[r], then we know that water can only be stored if the height[l] is also less than leftmax.

    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2) return 0;
        int sum = 0;

        int l = 0, r = n - 1;
        int leftMax = 0, rightMax = 0;
        while(l < r) {
            if(height[l] <= height[r]) {
                if(height[l] >= leftMax) leftMax = height[l];
                else {
                    sum += leftMax - height[l];
                }
                l++;
            } else {
                if(height[r] >= rightMax) rightMax = height[r];
                else {
                    sum += rightMax - height[r];
                }
                r--;
            }
        }

        return sum;
    }
}
