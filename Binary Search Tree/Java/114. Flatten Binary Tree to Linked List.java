*******************************Flatten a Binary Tree to Linked List*****************************************
Using 
class Solution {
   public void flatten(TreeNode root) {

      TreeNode curr = root;
      while (curr != null) {
         if (curr.left != null) {
            TreeNode prev = curr.left;
            while (prev.right != null) {
               prev = prev.right;
            }
            prev.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
         }
         curr = curr.right;
      }
   }
}


***************************Using recurrsion************************************

class Solution {
   TreeNode prev = null;
   public void flattenTree(TreeNode root) {
      if (root == null) return;
      flattenTree(root.right);
      flattenTree(root.left);
      root.right = prev;
      root.left = null;
      prev = root;
   }

   public void flatten(TreeNode root) {

      flattenTree(root);

   }
