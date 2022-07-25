package Search.medium;

public class RoatatedBinarySearch {
    //this approach here is somewhat imaginary...
    int search(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            //For those who struggled to figure out why it is realmid=(mid+rot)%n: you can think of it this way:
            //If we want to find realmid for array [4,5,6,7,0,1,2], you can shift the part before the rotating point
            // to the end of the array (after 2) so that the sorted array is "recovered" from the rotating point but
            // only longer, like this: [4, 5, 6, 7, 0, 1, 2, 4, 5, 6, 7]. The real mid in this longer array is the
            // middle point between the rotating point and the last element: (rot + (hi+rot)) / 2. (hi + rot) is the
            // index of the last element.
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
    //in this approach what we do is assume those numbers which are not on same side of target as either
    //MIN_value or max_value
    //Because it's not fully sorted, we can't do normal binary search. But here comes the trick:
    //
    //If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
    //[12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
    //
    //If target is let's say 7, then we adjust nums to this:
    //[-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int num = nums[mid];
            // If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                num = nums[mid];
            } else {
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            //first if they are on different side we just do normal bin search ...
            if (num < target)
                lo = mid + 1;
            else if (num > target)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
