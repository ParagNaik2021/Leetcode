public class Solution {
   public boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      if (head == null || head.next == null) return false;

      while (fast.next != null && fast.next.next != null) {
         fast = fast.next.next;
         slow = slow.next;

         if (slow == fast) {
            return true;
         }

      }
      return false;
   }
}