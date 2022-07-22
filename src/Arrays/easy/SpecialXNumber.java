package Arrays.easy;
/**the reason we used binary search here is to access that x from 1...n not from the list
 * because it may or may not be in the array ... hence apply binary search in list of number to find the smallest
 * number possible which satisfies the condtn*/
public class SpecialXNumber {
    public int specialArray(int[] nums) {
        int low = 0;
        int high =nums[0];
        for(int val:nums){
            high = Math.max(val,high);
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int m = count(nums,mid);
            if (m == mid) {
                return mid;
            } else if(m < mid){
                high = mid - 1;
            }else{
                low = mid + 1; //m > mid
            }
        }
        return ans;
    }

    public int count(int[] nums,int mid){
        int count = 0;
        for(int num  :nums){
            if(num >= mid){
                count++;
            }
        }
        return count;
    }
}
