//Approach-2(recursion):This is slitghty different the problem-25 in leetcode 
//video of-https://www.youtube.com/watch?v=znQ8wJxnRao

class Solution:
    def reverse(self,head, k):
        if head==None or k==1:
            return head

        nex=Node(0);
        prev=None
        c=0
        
        curr=Node(0)
        curr=head
        
        while curr!=None and c<k:
            nex=curr.next
            curr.next=prev
            prev=curr
            curr=nex
            c+=1
        
        if prev!=None:
            head.next=self.reverse(nex,k)
        
        return prev
        
        
        
       