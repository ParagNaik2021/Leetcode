*******************************Binary Tree Maximum Path Sum*****************************************

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        isMaxPath(root, maxPath);
        return maxPath[0];
    }

    int isMaxPath(TreeNode root, int[] maxPath) {
        if (root == null) return 0;

        int lh = Math.max(0, isMaxPath(root.left, maxPath));
        int rh = Math.max(0, isMaxPath(root.right, maxPath));
        maxPath[0] = Math.max(maxPath[0], root.val + lh + rh);
        return Math.max(lh, rh) + root.val;
    }
}
