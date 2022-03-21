import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
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


public class Practice {
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> ans2 = new ArrayList<>();
        ans2.set(0,0);
        String ans3 ="";
        return solve(root,ans3,ans2).get(0);
    }
    public List<Integer> solve(TreeNode root,String ans,List<Integer> ans1){
        if(root==null){
            return ans1;
        }
        if(root.right==null && root.left==null){
            ans1.set(0,ans1.get(0)+Integer.parseInt(ans,2));
            return ans1;
        }
        ans+=String.valueOf(root.val);
        ans1=solve(root.right,ans,ans1);
        ans1=solve(root.left,ans,ans1);
        return ans1;
    }
}
