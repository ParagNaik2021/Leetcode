*******************************GFG. Burning Tree*****************************************


class Solution {
   /*class Node {
   	int data;
   	Node left;
   	Node right;
   
   	Node(int data) {
   		this.data = data;
   		left = null;
   		right = null;
   	}
   }*/

   public static int findMaxDistance(Node root, int start) {
      HashMap < Node, Node > map = new HashMap < > ();
      Node target = bfsToMapParents(root, map, start);

      Queue < Node > Q = new LinkedList < > ();
      Q.offer(target);
      HashMap < Node, Integer > visited = new HashMap < > ();
      visited.put(target, 1);
      int burntTime = 0;
      while (!Q.isEmpty()) {
         int size = Q.size();
         int flag = 0;

         for (int i = 0; i < size; i++) {
            Node node = Q.poll();
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

   public static Node bfsToMapParents(Node root, HashMap < Node, Node > map, int start) {
      Queue < Node > Q = new LinkedList < > ();
      Q.offer(root);
      Node result = null;
      while (!Q.isEmpty()) {
         Node node = Q.peek();
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

   public static int minTime(Node root, int target) {
      int time = findMaxDistance(root, target);
      return time;
   }
}