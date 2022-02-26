class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        dummy=ListNode(0,head)
        leftprev,curr=dummy,head
        #reach till the left val of linked list
        for i in range(left-1):
            leftprev,curr=curr,curr.next
            
            
        prev=None
        for i in range(right-left+1):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
            
        leftprev.next.next=curr
        leftprev.next=prev
        return dummy.next