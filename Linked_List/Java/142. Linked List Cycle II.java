  public class Solution {
     public ListNode detectCycle(ListNode head) {
        //base case if head is empty or only single node

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        //start their movement    
        while (fast != null && fast.next != null)

        {
           slow = slow.next;
           fast = fast.next.next;

           if (slow == fast) break;

        }
        //if slow is pointing to head
        if (slow != fast) return null;

        while (head != slow) {
           slow = slow.next;
           head = head.next;
        }
        return head;
     }
  }