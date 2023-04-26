**********************************Optimal Solution***********************************************

class Solution {
    public ListNode deleteMiddle(ListNode head) {
    
    if(head==null || head.next==null) return null;
    ListNode dummy=new ListNode();
    dummy.next=head;
     ListNode fast=head;
     ListNode slow=head;
     while(fast!=null && fast.next!=null)
     {
         slow=slow.next;
         dummy=dummy.next;
         fast=fast.next.next;
     }

        dummy.next=dummy.next.next;

        return head;

    }
}