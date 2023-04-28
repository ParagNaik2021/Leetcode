**********************************************************Optimized Approach*************************************************************

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
       ListNode fast = dummy;
        ListNode slow = dummy; 
        for(int i=1;i<=n;i++)
        {
            fast=fast.next;
        }


        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;

        return dummy.next;
    }
}

Time Complexity: O(N)

Space Complexity: O(1)