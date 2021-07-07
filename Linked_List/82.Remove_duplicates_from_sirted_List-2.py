class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head:
            return head
        itr=head
        dummy=ListNode(0)
        dummy.next=head
        prev=dummy
        while itr:
            if itr.next!=None and itr.val==itr.next.val:
                while itr.next!=None and itr.val==itr.next.val:
                    itr=itr.next
                prev.next=itr.next
            else:
                prev=prev.next
            itr=itr.next
            
        return dummy.next