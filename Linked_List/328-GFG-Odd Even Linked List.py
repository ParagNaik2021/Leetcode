class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head==None or head.next==None:
            return head
        odd,even=head,head.next
        evenHead=even
        while odd.next!=None and even.next!=None:
            odd.next=even.next
            odd=odd.next
            even.next=odd.next
            even=even.next
            
        odd.next=evenHead
        return head