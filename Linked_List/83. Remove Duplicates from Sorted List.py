class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        itr=head
        if itr is None:
            return None
        if itr.next is None:
            return itr
        current=itr
        current_next=itr.next
        while current.next:
            if current.val!=current_next.val:
                current=current.next
                current_next=current_next.next 
            else:
                current.next=current_next.next
                current_next=current_next.next                                                
        return itr