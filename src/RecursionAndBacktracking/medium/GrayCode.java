package RecursionAndBacktracking.medium;

import java.util.ArrayList;
import java.util.List;
//there is no specific intuition here ... we just need to figure the pattern ...
//for n=3 we will use n=2 and n=1 as answers also by keeping n==1 as base case
public class GrayCode {
    List<Integer> formGreyCode(int bitNo){
        if(bitNo == 1){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }
        List<Integer> ans = formGreyCode(bitNo - 1);
        int addFactor = ans.size();
        int n = ans.size();
        for(int i=n-1; i>=0; i--){
            ans.add(ans.get(i) + addFactor);
        }
        return ans;
    }

    public List<Integer> grayCode(int n) {
        return formGreyCode(n);
    }
}
