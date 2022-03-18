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
    public TreeNode searchBST(TreeNode root, int val) {
        return returnSubtree(root,val);
    }

    public TreeNode returnSubtree(TreeNode root,int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root ;
        }
        else if(root.val>val){
            return returnSubtree(root.left,val);
        }
        else  {
            return returnSubtree(root.right,val);
        }
    }
}
