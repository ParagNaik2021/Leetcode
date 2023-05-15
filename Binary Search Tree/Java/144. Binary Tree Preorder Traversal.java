*******************************Preorder Traversal-->Recurssive Approach*****************************************
class Solution {

    public void preOrderHelper(TreeNode root, List < Integer > preorder) {
        if (root == null) return;

        preorder.add(root.val);
        preOrderHelper(root.left, preorder);
        preOrderHelper(root.right, preorder);

    }

    public List < Integer > preorderTraversal(TreeNode root) {

        //Recursive Approach
        List < Integer > preorder = new ArrayList < Integer > ();
        preOrderHelper(root, preorder);
        return preorder;
    }
}