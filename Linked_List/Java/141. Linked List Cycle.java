#################################################Optimized solution############################################

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


#################################################Optimized solution############################################

public class Solution {
    public boolean hasCycle(ListNode head) {
       HashSet<ListNode> set=new HashSet<>();
       ListNode curr=head;
       while(curr!=null){
           if(set.contains(curr)) return true;
           set.add(curr);
           curr=curr.next;
       }
       return false;
    }
}