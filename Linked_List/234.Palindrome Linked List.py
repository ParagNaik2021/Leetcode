class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        def reverse(head):
            pre,nex=None,None
            while head!=None:
                nex=head.next
                head.next=pre
                pre=head
                head=nex                
            return pre
        
        if head==None or head.next==None:
            return True
        
        #finding the middle of the linked list
        slow,fast=head,head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
            
        #calling the reverse func to linked list after middle
        slow.next=reverse(slow.next)

        #increment the slow as it will become head of the reverse linked list 
        slow=slow.next
        
        #check both the linked list data
        while slow!=None:
            if head.val!=slow.val:
                return False
            
            head=head.next
            slow=slow.next
            
        return True
            
        
        
        
        
        