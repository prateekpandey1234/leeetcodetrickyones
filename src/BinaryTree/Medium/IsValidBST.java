package BinaryTree.Medium;
/**here the major approach is to store the MIN,MAX value from our ancestors using 2 extra parameters
 * it's the optimal soln*/
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        boolean isLeftValid = helper(root.left, min, root.val);
        boolean isRightValid = helper(root.right, root.val, max);
        return root.val < max && root.val > min && isLeftValid && isRightValid;
    }
}
