*******************************103. check if Tree are Symmetrical*****************************************

class Solution {
    public boolean Symmetric(TreeNode left,TreeNode right)
    {
            if(left==null || right==null) return (left==right);

            if(left.val!=right.val) return false;

            return (Symmetric(left.left,right.right) && Symmetric(left.right,right.left));
    }
    public boolean isSymmetric(TreeNode root) {
     
        if(root==null) return true;
        return (root==null || Symmetric(root.left,root.right)); 
    }
}
