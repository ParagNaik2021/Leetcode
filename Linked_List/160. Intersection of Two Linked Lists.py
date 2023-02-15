class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA is None or headB is None:
            return None
        
        itr1,itr2=headA,headB
        
        while itr1!=itr2:
            if itr1 is None:
                itr1=headB
            else:
                itr1=itr1.next
            if itr2 is None:
                itr2=headA
            else:
                itr2=itr2.next
                
        return itr1