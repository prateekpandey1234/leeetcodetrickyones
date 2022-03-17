package BinaryTree;

import java.util.HashMap;

public class BinaryTreeTwoSumEasy {
    //pre order  Vist -> Left -> Right
    HashMap<Integer, Integer> keyvalue = new HashMap<Integer, Integer>();
    boolean result = false;

    public void traversal(TreeNode root, int k){

        if(root==null)
            return;

        int remainvalue = k - root.val;
        if(keyvalue.containsKey(remainvalue)){

            result = true;
            return;
        }
        else{
            keyvalue.put(root.val,1);
        }

        traversal(root.left,k);
        traversal(root.right,k);

    }

    public boolean findTarget(TreeNode root, int k) {

        traversal(root,k);

        return result;

    }
    //alternative soln recursion
    private boolean searchInBST(TreeNode root, int val) {
        return root != null && ((root.val < val) ?
                searchInBST(root.right, val) : root.val <= val || searchInBST(root.left, val));
    }

    private void inorder(TreeNode root, int target, TreeNode parentNode) {
        if (root != null && !noNeedToSearchNow) {
            inorder(root.left, target, parentNode);
            if (root.val*2!=target && searchInBST(parentNode, target - root.val))
                noNeedToSearchNow = true;
            inorder(root.right, target, parentNode);
        }
    }

    boolean noNeedToSearchNow;

    public boolean findTarget1(TreeNode root, int target) {
        noNeedToSearchNow = false;
        inorder(root, target, root);
        return noNeedToSearchNow;
    }
}
