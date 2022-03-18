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
    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer> ans1 = new ArrayList<>();
        ans1=sort1(root,ans1);
        Collections.sort(ans1);
        if(ans1.size()==1){
            return -1;
        }
        return ans1.get(1);
    }
    public ArrayList<Integer> sort1(TreeNode root, ArrayList<Integer> ans){
        if(root==null){
        return ans;
        }
        if(root.right==null && root.left==null){
            ans.add(root.val);
            return ans;
        }
        ans = sort1(root.right,ans);
        ans = sort1(root.left,ans);
        return ans;
    }
}
