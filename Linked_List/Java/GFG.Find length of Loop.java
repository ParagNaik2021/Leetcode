class Solution {
   //Function to find the length of a loop in the linked list.
   static int countNodesinLoop(Node head) {

      //Add your code here.
      Node slow = head;
      Node fast = head;

      if (head == null || head.next == null)
         return 0;

      int count = 1;
      while (fast.next != null && fast.next.next != null) {
         fast = fast.next.next;
         slow = slow.next;
         if (slow == fast) {
            break;
         }
      }

      while (fast.next != null && fast.next.next != null) {
         fast = fast.next;
         if (slow == fast) {
            return count;
         }
         count++;
      }

      return 0;

   }
}