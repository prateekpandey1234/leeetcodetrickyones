
import BinaryTree.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Practice {
    public List<Integer> partitionLabels(String s) {
        int[]  arr = new int[26];
        Arrays.fill(arr,-1);
        arr[s.charAt(0)-'a']=0;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int j=0;j<s.length();j++){
            if(arr[s.charAt(j)-'a']!=-1){
                while(ans.size()!=arr[s.charAt(j)]+1)ans.remove(ans.size()-1);
                int curr= ans.get(ans.size()-1);
                ans.remove(ans.size()-1);
                ans.add(curr+1);
            }
            else{
                ans.add(1);
                arr[s.charAt(j)-'a']=ans.size()-1;
            }
        }
        return ans;
    }

}
