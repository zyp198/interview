package code.leet;

import org.junit.Test;

public class DFSSolution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeDepth(TreeNode root) {
        // 递归出口，空树的高度为0
        if (root == null) {
            return 0;
        }
        // 当前二叉树的高度 = max(左子树高度,右子树高度) + 1
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    @Test
    public void mainTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isBalanced(root));
    }
}
