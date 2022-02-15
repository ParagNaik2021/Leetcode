class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy=ListNode(0,head)
        prev,curr=dummy,head
        
        while curr and curr.next:
            nextPair=curr.next.next
            second=curr.next
            
            #swapping
            second.next=curr
            curr.next=nextPair
            prev.next=second
            
            #update value in nextPair and second
            # prev=second.next
            prev=curr
            curr=nextPair
            
        return dummy.next


#################--Recurssion--###########################

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy=ListNode(0,head)
        prev,curr=dummy,head
        
        def swapNode(prev,curr):
            if curr==None or curr.next==None:
                return dummy.next
            
            nextPair=curr.next.next
            second=curr.next
            
            #swapping
            second.next=curr
            curr.next=nextPair
            prev.next=second
            #recurrsion call
            swapNode(curr,nextPair)
        
        swapNode(prev,curr)
        
        return dummy.next