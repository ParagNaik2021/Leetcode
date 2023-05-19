*******************************Zig Zag Traversals*****************************************
class Solution {
   public List < List < Integer >> zigzagLevelOrder(TreeNode root) {
      List < List < Integer >> wrapList = new LinkedList < > ();
      Queue < TreeNode > Q = new LinkedList < > ();
      if (root == null) return wrapList;
      boolean flag = true;

      Q.offer(root);
      while (!Q.isEmpty()) {

         int levelNum = Q.size();
         List < Integer > subList = new LinkedList < > ();
         for (int i = 0; i < levelNum; i++) {

            if (Q.peek().left != null)
               Q.offer(Q.peek().left);
            if (Q.peek().right != null)
               Q.offer(Q.peek().right);

            if (flag == true) subList.add(Q.poll().val);
            else subList.add(0, Q.poll().val);

         }
         flag = !flag;
         wrapList.add(subList);
      }
      return wrapList;
   }
}
