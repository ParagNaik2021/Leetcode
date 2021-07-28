class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy=ListNode
        temp=dummy
        carry=0
        while l1 or l2 or carry>0:
            addition=0
            if l1 is not None:
                addition+=l1.val
                l1=l1.next
            if l2 is not None:
                addition+=l2.val
                l2=l2.next     
            addition+=carry
            carry=addition//10
            if carry>0:
                addition=addition%10
            node=ListNode(addition)
            temp.next=node
            temp=temp.next
        return dummy.next