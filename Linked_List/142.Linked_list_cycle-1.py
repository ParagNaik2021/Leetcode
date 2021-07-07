class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        if head==None or head.next==None:
            return None

        slow=head
        fast=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
            if slow == fast:
                break       
        if slow!=fast:
            return None
        
        while head != slow:
            slow = slow.next
            head = head.next
        return head