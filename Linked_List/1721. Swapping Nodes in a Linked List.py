class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        fast,slow=head,head
        first,second=head,head
        
        for i in range(k-1):
            fast=fast.next
        first=fast
        
        while fast.next:
            slow=slow.next
            fast=fast.next
        second=slow
        
        #swapping
        first.val,second.val=second.val,first.val
        
        return head