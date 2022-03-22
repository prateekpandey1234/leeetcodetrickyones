package BinaryTree.Easy;




public class BinaryMaxDepthEasy {
    public int maxDepth(TreeNode root) {
        int count = 1;
        return godeep(root,count)-1;
    }
    public int godeep(TreeNode root, int count){
        if(root==null){
            return count;
        }
        count+=1;
        int count1 = 0;
        count1+=count;
        return Math.max(godeep(root.left,count),godeep(root.right,count1));
    }
}
