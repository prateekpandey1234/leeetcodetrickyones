import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Practice {
    public int reversePairs(int[] nums) {
        int count =0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length && nums[i]*2<=nums[nums.length-1];i++)count++;
        return count;
    }
}
