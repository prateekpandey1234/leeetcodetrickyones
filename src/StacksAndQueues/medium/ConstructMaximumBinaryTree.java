package StacksAndQueues.medium;

import BinaryTree.TreeNode;

import java.util.Stack;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();

        for (int num : nums) {
            TreeNode current = new TreeNode(num);

            while (!stack.isEmpty() && stack.peek().val < num) {
                current.left = stack.pop();// so as we are poping the nums from stck we need to also curr.left as it will
                //set the treenodes which will be on the left side of num[i] and smaller than num[i]
            }

            if (!stack.isEmpty()) {
                stack.peek().right = current;//this indicates we have found our new head of our linkedlist
            }

            stack.push(current);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.isEmpty() ? null : stack.peek();
    }
}
