class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if k==0 or head==None or head.next==None: #edge cases-when k=0 or only 1 node or no node
            return head
        itr=head  
        l=1      #give initial value 1 not 0 it will throw an error
        while itr.next:
            l+=1
            itr=itr.next            
        k=k%l    
        if k==0:
            return head
        itr.next=head
        k=l-k
        while k!=0:
            k-=1
            itr=itr.next
        
        head=itr.next
        itr.next=None
        return head