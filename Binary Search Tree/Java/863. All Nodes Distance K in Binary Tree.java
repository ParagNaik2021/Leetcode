*******************************863. All Nodes Distance K in Binary Tree*****************************************

class Solution {
   public void markParents(TreeNode root, HashMap < TreeNode, TreeNode > parent_track) {
      Queue < TreeNode > Q = new LinkedList < TreeNode > ();
      Q.offer(root);
      while (!Q.isEmpty()) {
         TreeNode curr = Q.poll();
         if (curr.left != null) {
            parent_track.put(curr.left, curr);
            Q.offer(curr.left);
         }

         if (curr.right != null) {
            parent_track.put(curr.right, curr);
            Q.offer(curr.right);
         }
      }

   }
   public List < Integer > distanceK(TreeNode root, TreeNode target, int k) {
      HashMap < TreeNode, TreeNode > parent_track = new HashMap < > ();
      markParents(root, parent_track);
      List < Integer > result = new ArrayList < > ();
      HashMap < TreeNode, Boolean > visited = new HashMap < > ();
      Queue < TreeNode > Q = new LinkedList < TreeNode > ();
      Q.offer(target);
      visited.put(target, true);
      int curr_level = 0;
      while (!Q.isEmpty()) {
         int size = Q.size();
         if (curr_level == k) break;
         curr_level++;
         for (int i = 0; i < size; i++) {
            TreeNode curr = Q.poll();
            if (curr.left != null && visited.get(curr.left) == null) {
               Q.offer(curr.left);
               visited.put(curr.left, true);
            }
            if (curr.right != null && visited.get(curr.right) == null) {
               Q.offer(curr.right);
               visited.put(curr.right, true);
            }
            if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
               Q.offer(parent_track.get(curr));
               visited.put(parent_track.get(curr), true);
            }
         }

      }

      while (!Q.isEmpty()) {
         TreeNode curr = Q.poll();
         result.add(curr.val);
      }
      return result;

   }
}
