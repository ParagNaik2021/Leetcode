class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        hare,tortoise=head,head
        while hare and hare.next:
            hare=hare.next.next
            tortoise=tortoise.next
        return tortoise