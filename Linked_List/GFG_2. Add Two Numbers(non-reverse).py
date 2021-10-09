class Solution:
    #Function to add two numbers represented by linked list.
    def addTwoLists(self, first, second):
        def reverse1(head):
            pre=None
            nex=None
            while head!=None:
                nex=head.next
                head.next=pre
                pre=head
                head=nex
            return pre
        
        first=reverse1(first)
        second=reverse1(second)
        dummy=Node(0)
        temp=dummy
        carry=0
        while first or second or carry>0:
            addition=0
            if first is not None:
                addition+=first.data
                first=first.next
                
            if second is not None:
                addition+=second.data
                second=second.next
            addition+=carry
            carry=addition//10
            if carry>0:
                addition=addition%10
            temp.next=Node(addition)    
            temp=temp.next
            
        return reverse1(dummy.next)