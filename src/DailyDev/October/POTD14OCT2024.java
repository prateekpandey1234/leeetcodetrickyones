package DailyDev.October;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class POTD14OCT2024 {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        ArrayList<Integer> arr ;
        public int kthLargestPerfectSubtree(TreeNode root, int k) {
            arr=new ArrayList<>();
            dfs(root);
            Collections.sort(arr);
            return (k-1>=arr.size())?-1:arr.get(arr.size()-k);
        }
        public int dfs(TreeNode root){
            if(root.left==null && root.right==null){
                arr.add(1);
                return 1;
            }
            else if(root.left==null){
                dfs(root.right);
                return -1;
            }
            else if(root.right==null){
                dfs(root.left);
                return -1;
            }
            else{
                int r=dfs(root.right);
                int l =dfs(root.left);
                if(l==r){
                    arr.add(l+r+1);
                    return l+r+1;
                }
                return -1;
            }
        }
    }
    public int maxRemovals(String s ,String p, int[] nums) {
        int[] dp = new int[nums.length];
        return memo(dp,nums,0,0,p,s.toCharArray());
    }
    public int memo(int[] dp,int[] nums,int ans,int i,String p,char[] s){
        if(i>=nums.length){
            return (IsSubString(Arrays.toString(s),p))?ans:0;
        }
        if(dp[i]!=0)return dp[i];
        char b =s[i];
        s[i]= ' ';
        int l1 = memo(dp,nums,ans+1,i+1,p,s);
        s[i]=b;
        int l2 = memo(dp,nums,ans,i+1,p,s);
        return Math.max(l1,l2);
    }
    public boolean IsSubString(String s , String p){
        int i=0,j=0;
        while(i<s.length() && j<p.length()){
            if(s.charAt(i)==p.charAt(j))j++;
            i++;
        }
        System.out.println(s+"#"+p);
        return j==p.length();
    }
}
