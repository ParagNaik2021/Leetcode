*******************************PostOrder Traversal-->Recurssive Approach*****************************************

class Solution {

     public void postOrderHelper(TreeNode root, List < Integer > postorder) {
        if (root == null) return;
        postOrderHelper(root.left, postorder);
        postOrderHelper(root.right, postorder);
        postorder.add(root.val);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
       List < Integer > postorder = new ArrayList < > ();
        postOrderHelper(root, postorder);
        return postorder;   
    }
}