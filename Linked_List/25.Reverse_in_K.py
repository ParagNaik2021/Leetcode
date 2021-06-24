//Approach-1 (striver solution) :This is the leetcode problem where if we dont have k nodes remaining in the linked list we dont reverse them


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if head==None or k==1:
            return head
        
        dummy=ListNode(0)
        dummy.next=head
        
        curr,nex,prev=dummy,dummy,dummy
        count=0
        while curr.next!=None:
            count+=1
            curr=curr.next
        while count>=k:
            curr=prev.next
            nex=curr.next
            for i in range(k-1):
                curr.next=nex.next
                nex.next=prev.next
                prev.next=nex
                nex=curr.next
            prev=curr
            count-=k
        return dummy.next