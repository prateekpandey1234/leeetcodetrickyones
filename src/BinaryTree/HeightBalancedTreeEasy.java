package BinaryTree;

public class HeightBalancedTreeEasy {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return constructTree(nums,0,nums.length-1);
    }

    public TreeNode constructTree(int[]nums,int left,int right){
        if(left>right)return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left = constructTree(nums,left,mid-1);
        root.right = constructTree(nums,mid+1,right);

        return root;

    }
}
