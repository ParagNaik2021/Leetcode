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


*******************************Inorder Traversal-->Iterative Approach*****************************************

class Solution {
   public List < Integer > inorderTraversal(TreeNode root) {

      List < Integer > inorder = new ArrayList < > ();
      Stack < TreeNode > st = new Stack < > ();

      while (!st.empty() || root != null) {
         // if the current node exists, push it into the stack (defer it)
         // and move to its left child
         if (root != null) {
            st.push(root);
            root = root.left;
         } else {
            // otherwise, if the current node is null, pop an element from
            // the stack, print it, and finally set the current node to its
            // right child
            root = st.pop();
            inorder.add(root.val);
            root = root.right;
         }
      }
      return inorder;
   }
}