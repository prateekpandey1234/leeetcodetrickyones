package RecursionAndBacktracking.medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryStrings {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        TreeNode root = new TreeNode(0); //as a sentinel node
        getAns(n, ans, root, 0);
        return ans;
    }

    private void getAns(int n, List<TreeNode> ans, TreeNode root, int count) {
        if (count == n) {
            //Copy the current tree and add it to the result
            TreeNode newRoot = treeCopy(root);
            ans.add(newRoot.right);
            return;
        }
        TreeNode root_copy = root;
        // try to insert each number
        for (int i = 1; i <= n; i++) {
            root = root_copy;
            // Find the position to insert
            while (root != null) {
                //insert in the left subtree
                if (i < root. val) {
                    //to the far left
                    if (root. left==null) {
                        //insert the current number
                        root. left = new TreeNode(i);
                        // enter recursion
                        getAns(n, ans, root_copy, count + 1);
                        //Revert to null, try to insert the next number
                        root. left = null;
                        break;
                    }
                    root = root. left;
                    //insert into the right subtree
                } else if (i > root.val){
                    //to the far right
                    if (root. right == null){
                        //insert the current number
                        root.right = new TreeNode(i);
                        // enter recursion
                        getAns(n, ans, root_copy, count + 1);
                        //Revert to null, try to insert the next number
                        root.right = null;
                        break;
                    }
                    root = root.right;
                    // if an equal number is found, end and try the next number
                } else {
                    break;
                }
            }
        }
    }
    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot. left = treeCopy(root. left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }
}
