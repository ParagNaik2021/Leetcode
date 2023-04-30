*********************Optimal Solution***************************8

class Solution {
   public Node copyRandomList(Node head) {
      Node temp = head;

      //Step 1 - to create a deep copy node and point the original to deep copy node
      while (temp != null) {
         Node newNode = new Node(temp.val);
         newNode.next = temp.next;
         temp.next = newNode;
         temp = temp.next.next;
      }

      //Step 2- connect the random node of deep according to original LL node
      Node itr = head;
      while (itr != null) {
         if (itr.random != null) {
            itr.next.random = itr.random.next;
         }
         itr = itr.next.next;
      }

      //Step 3- seperate the deep copy and original LL
      Node dummy = new Node(0);
      itr = head;
      temp = dummy;
      Node front;
      while (itr != null) {
         front = itr.next.next;
         temp.next = itr.next;
         itr.next = front;
         temp = temp.next;
         itr = front;
      }
      return dummy.next;

   }
}