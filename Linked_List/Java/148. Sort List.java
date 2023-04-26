*******************************Optimal Solution*********************************8
TC-->O(NLogN)


class Solution {
    public ListNode getMiddle(ListNode head)
    {
     ListNode slow=head;
     ListNode fast=head;

     while(fast.next!=null && fast.next.next!=null)
     {
         slow=slow.next;
         fast=fast.next.next;
     }
        return slow;
    }

    public ListNode sortedMerge(ListNode left,ListNode right)
    {
        ListNode result=new ListNode();
        if(left==null)  return right;
        if(right==null) return left;
        if(left.val<right.val) {
            result=left;
            result.next=sortedMerge(left.next,right);
        }
        else{
            result=right;
            result.next=sortedMerge(left,right.next);
        }

        return result;
            }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode middle=getMiddle(head);
        ListNode middleNext=middle.next;
        middle.next=null;


        ListNode left=sortList(head);
        ListNode right=sortList(middleNext);

        ListNode sortedList=sortedMerge(left,right);

        return sortedList;

    }
}