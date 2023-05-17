*******************************PostOrder Traversal-->Iterative 1 stack appraoch Approach*****************************************

class Solution {
   public List < Integer > postorderTraversal(TreeNode root) {
      List < Integer > postorder = new ArrayList < > ();
      Stack < TreeNode > st = new Stack < > ();
      if (root == null) return postorder;
      TreeNode curr = root;
      TreeNode temp = null;

      while (curr != null || !st.isEmpty()) {
         if (curr != null) {
            st.push(curr);
            curr = curr.left;
         } else {
            temp = st.peek().right;

            if (temp == null) {
               temp = st.pop();
               postorder.add(temp.val);

               while (!st.isEmpty() && temp == st.peek().right) {
                  temp = st.pop();
                  postorder.add(temp.val);
               }
            } else {
               curr = temp;
            }
         }
      }

      return postorder;
   }
}