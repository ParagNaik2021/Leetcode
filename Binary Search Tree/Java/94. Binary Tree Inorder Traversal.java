*******************************Inorder Traversal-->Recurssive Approach*****************************************

class Solution {

    public void inOrderHelper(TreeNode root, List < Integer > inorder) {
        if (root == null) return;
        inOrderHelper(root.left, inorder);
        inorder.add(root.val);
        inOrderHelper(root.right, inorder);
    }
    public List < Integer > inorderTraversal(TreeNode root) {
        //Recurssion
        List < Integer > inorder = new ArrayList < > ();
        inOrderHelper(root, inorder);
        return inorder;
    }

}