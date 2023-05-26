*******************************Coding Ninja- Time To Burn Tree *****************************************

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
   public static int findMaxDistance(HashMap < BinaryTreeNode < Integer > , BinaryTreeNode < Integer >> map, BinaryTreeNode < Integer > target) {
      Queue < BinaryTreeNode < Integer >> Q = new LinkedList < > ();
      Q.offer(target);
      HashMap < BinaryTreeNode < Integer > , Integer > visited = new HashMap < > ();
      visited.put(target, 1);
      int burntTime = 0;
      while (!Q.isEmpty()) {
         int size = Q.size();
         int flag = 0;

         for (int i = 0; i < size; i++) {
            BinaryTreeNode < Integer > node = Q.poll();
            //checking if left node is not null and rif visted
            if (node.left != null && visited.get(node.left) == null) {
               flag = 1;
               visited.put(node.left, 1);
               Q.offer(node.left);
            }

            if (node.right != null && visited.get(node.right) == null) {
               flag = 1;
               visited.put(node.right, 1);
               Q.offer(node.right);
            }
            //the parent node
            if (map.get(node) != null && visited.get(map.get(node)) == null) {
               flag = 1;
               visited.put(map.get(node), 1);
               Q.offer(map.get(node));
            }

         }
         if (flag == 1) burntTime += 1;

      }
      return burntTime;

   }
   public static BinaryTreeNode < Integer > bfsToMapParents(BinaryTreeNode < Integer > root, HashMap < BinaryTreeNode < Integer > , BinaryTreeNode < Integer >> map, int start) {
      Queue < BinaryTreeNode < Integer >> Q = new LinkedList < > ();
      Q.offer(root);
      BinaryTreeNode < Integer > result = new BinaryTreeNode < > (-1);
      while (!Q.isEmpty()) {
         BinaryTreeNode < Integer > node = Q.peek();
         if (node.data == start) result = node;
         Q.poll();
         if (node.left != null) {
            map.put(node.left, node);
            Q.offer(node.left);

         }
         if (node.right != null) {
            map.put(node.right, node);
            Q.offer(node.right);

         }

      }
      return result;
   }
   public static int timeToBurnTree(BinaryTreeNode < Integer > root, int start) {
      // Write your code here.
      HashMap < BinaryTreeNode < Integer > , BinaryTreeNode < Integer >> map = new HashMap < > ();
      BinaryTreeNode < Integer > target = bfsToMapParents(root, map, start);
      int time = findMaxDistance(map, target);
      return time;
   }
}
