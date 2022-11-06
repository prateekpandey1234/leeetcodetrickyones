package RecursionAndBacktracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//the intuition here is to skip those elements which are repeating and basically follow the subset method
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //we have to sort the input to easily go through duplicates..
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos) {
        res.add(new ArrayList<>(ls));//Constructs a list containing the elements of the specified collection,
                                     // in the order they are returned by the collection's iterator.
        for(int i=pos;i<nums.length && !ls.isEmpty() ;i++) {
            //avoiding the duplicates
            if(ls.contains(nums[i]))
            if(i>pos&&nums[i]==nums[i-1]) continue;
            ls.add(nums[i]);
            helper(res,ls,nums,i+1);
            ls.remove(ls.size()-1);
        }}
}
