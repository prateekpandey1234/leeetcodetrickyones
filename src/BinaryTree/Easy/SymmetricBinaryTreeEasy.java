package BinaryTree.Easy;



public class SymmetricBinaryTreeEasy {
    //recursive approach for checking if tree is symmetric
    public boolean isSymmetric( TreeNode root){
        return isSysmmetriccheck(root.right,root.left);
    }
    private boolean isSysmmetriccheck(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return root1.val==root2.val && isSysmmetriccheck(root1.left,root2.right) && isSysmmetriccheck(root1.right,root2.left);
    }

}
