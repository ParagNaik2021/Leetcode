class Solution:
    def splitList(self, head, head1, head2):
        #code here
        slow=head
        fast=head.next
        while fast!=head and fast.next!=head:
            slow=slow.next
            fast=fast.next.next
            
        head1=head
        head2=slow.next
        slow.next=head1
        
        current=Node()
        current=head2
        while current.next!=head:
            current=current.next
        current.next=head2
        
        #this is to emulate pass by reference in python please don't delete below line.
        return head1,head2