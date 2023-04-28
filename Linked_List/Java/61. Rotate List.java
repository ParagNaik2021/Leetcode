*****************************Optimal Solution**************************************************

class Solution {
   public ListNode rotateRight(ListNode head, int k) {
      if (k == 0 || head == null || head.next == null) return head;

      ListNode itr = head;
      int len = 1;
      while (itr.next != null) {
         len++;
         itr = itr.next;
      }
      k = k % len;
      if (k == 0) return head;

      itr.next = head;
      k = len - k;
      while (k != 0) {
         k--;
         itr = itr.next;
      }
      head = itr.next;
      itr.next = null;
      return head;
   }
}


*****************************************************************************************************
GFG-Rotate a Linked List

class Solution {
   //Function to rotate a linked list.
   public Node rotate(Node head, int k) {
      Node curr = head;

      for (int i = 1; i < k; i++) {
         curr = curr.next;
      }

      Node end = curr;
      while (end.next != null) {
         end = end.next;
      }

      end.next = head;
      Node newHead = curr.next;
      curr.next = null;

      return newHead;

   }
}
