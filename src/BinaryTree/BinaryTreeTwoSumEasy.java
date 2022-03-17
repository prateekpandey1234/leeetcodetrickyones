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
}
