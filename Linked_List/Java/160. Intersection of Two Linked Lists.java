public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itr1=headA;
        ListNode itr2=headB;

        while(itr1!=itr2)
        {
            if(itr1!=null) 
            {
                itr1=itr1.next;
            }
            else
            {
                itr1=headB;
            }

             if(itr2!=null)
             {
                 itr2=itr2.next;
             }
             else
             {
                 itr2=headA;
             }
        }
        return itr1;
    }
}