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

***********************************PreOrder Traversal-->Iterative Approach*******************************************

class Solution {
   public List < Integer > preorderTraversal(TreeNode root) {
      List < Integer > preorder = new ArrayList < > ();
      Stack < TreeNode > st = new Stack < > ();
      if (root == null) return preorder;
      st.push(root);
      while (!st.empty()) {
         root = st.pop();
         preorder.add(root.val);
         if (root.right != null) st.push(root.right);
         if (root.left != null) st.push(root.left);
      }
      return preorder;
   }
}
