import java.lang.reflect.Array;
import java.util.*;

public class Practice {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int currcnt = 1;
        int maxcnt = 0;
        int j = 0;
        System.out.print(Arrays.toString(nums));
        while(j<nums.length){
            if(nums[j+1]-nums[j]==1){
                currcnt+=1;
            }else {
                if(currcnt>maxcnt){
                    maxcnt=currcnt;
                    currcnt=1;
                }
            }
            j++;
        }
        return maxcnt;
    }
}
