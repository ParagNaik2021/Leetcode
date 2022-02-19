class Solution:
    def divide(self, N, head):
        # code here
        even=None
        odd=None
        e,o=None,None
        while head:
            if head.data%2==0:
                if even==None:
                    even=head
                    e=head
                else:
                    e.next=head
                    e=e.next
            else:
                if odd==None:
                    odd=head
                    o=head
                else:
                    o.next=head
                    o=o.next
            head=head.next
        if e:
            e.next=odd
        if o:
            o.next=None
        if even:
            return even
        return odd