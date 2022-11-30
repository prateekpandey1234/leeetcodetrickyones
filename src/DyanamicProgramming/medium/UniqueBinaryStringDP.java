package DyanamicProgramming.medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryStringDP {
    //The above is all the process of deriving [1 2 3] according to [1 2], and the code can be written.
    // Since only the last solution is needed to find all the current solutions, we only need two lists,
    // pre saves all the last solutions, and cur calculates all the current solutions.
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre. add(null);
        //Increase a number each time
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //Loop through all previous solutions
            for (TreeNode root : pre) {
                //insert into the root node
                TreeNode insert = new TreeNode(i);
                insert. left = root;
                cur. add(insert);
                //Insert into the right child, the right child of the right child...find up to n times of children
                for (int j = 0; j <= n; j++) {

                    TreeNode root_copy = treeCopy(root); //Copy the current tree
                    TreeNode right = root_copy; //Find the position to insert the right child
                    int k = 0;
                    //traverse j times to find the right child
                    for (; k < j; k++) {
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    // Reaching null ends early
                    if (right == null)
                        break;
                    //what we are doing here is we are using previous subtrees, and firstly we are adding new node to the
                    //bottom right of subtree
                    //and then we are adding every previous subtree to the left of that node
                    //Save the subtree where the current right child is located as the left child of the inserted node
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //right child is the inserted node
                    insert.left = rightTree; //The left child of the inserted node is updated to the subtree before the insertion position
                    //Add to result
                    cur.add(root_copy);
                }
            }
            pre = cur;

        }
        return pre;
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
