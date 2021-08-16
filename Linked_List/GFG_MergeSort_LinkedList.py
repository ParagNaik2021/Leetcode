# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortedMerge(self,left,right):
        result=None
        if left==None:
            return right
        if right==None:
            return left
        if left.val<=right.val:
            result=left
            result.next=self.sortedMerge(left.next,right)
        else:
            result=right
            result.next=self.sortedMerge(left,right.next)
            
        return result
    
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head==None or head.next==None:
            return head
        middle=self.getMiddle(head)
        nexttomiddle=middle.next
        middle.next=None
        
        left=self.sortList(head)
        right=self.sortList(nexttomiddle)
        
        sortedlist=self.sortedMerge(left,right)
        
        return sortedlist
        
        
        
    def getMiddle(self,head):
        if head==None:
            return head
        
        slow=head
        fast=head
        
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
            
        return slow