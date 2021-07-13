def findIntersection(head1,head2):
    itr1,itr2=head1,head2
    head=None
    curr=None
    while itr1 and itr2:
        if itr1.data==itr2.data:
            if head==None:   #if it is the first element in the linked list
                t=Node(itr1.data)
                head=t
                curr=t
                
            else:
                t=Node(itr1.data)
                curr.next=t
                curr=curr.next
            itr1=itr1.next
            itr2=itr2.next
            
        elif itr1.data<itr2.data:
            itr1=itr1.next
        else:
            itr2=itr2.next
            
    return head