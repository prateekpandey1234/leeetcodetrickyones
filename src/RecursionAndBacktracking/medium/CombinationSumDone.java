package RecursionAndBacktracking.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumDone {
    private void findCombinations(int ind, int[] arr, int target, List <List< Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList< >(ds));
            }
            return;
        }
        //we are not using for loop because in previous question we were asked to avoid duplicates combinations
        // like [1,2,4] and [2,1,4]...
        //here we have to work with the duplicates...
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public List < List < Integer >> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
}
