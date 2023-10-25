package DyanamicProgramming.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestAdjacentGroupSubsequence {class Solution {
//doing normal types of state based dp here will be confusing so , what we will do is :-
    // 1.add our base cases which are single string lists
    //2. check validity of each string with other using for loop
    //3.then check if  our current dp list at i is smaller than dp list at  j
    //4. if so then update ith list with jth also add the ith word in that list
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<List<String>> dp =  new ArrayList<>();
        int len = 1;
        for(int i=0;i<n;i++){
            List<String> curr = new ArrayList<>();
            curr.add(words[i]);
            dp.add(curr);//adding our base cases as first lists only containing single string
            for(int j=0;j<i;j++){
                if(groups[i] !=groups[j] && valid(words[i],words[j])){
                    //here 1 represents the current check with j element
                    // we will add those list to ith value that we have found on jth index earlier
                    if(1+dp.get(j).size() > dp.get(i).size()){// checking if we can increase list size
                        dp.set(i, new ArrayList<>(dp.get(j)));
                        dp.get(i).add(words[i]);
                        len = Math.max(len, dp.get(i).size());
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(List<String> it : dp) {
            if(it.size() == len) {
                res.addAll(it);
                break;
            }
        }
        return res;
    }

    public boolean valid(String a , String b){
        if(a.length()!=b.length())return false;
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))cnt++;if(cnt>1)return false;
        }
        return true;
    }
}
}
