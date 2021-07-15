def isCircular(head):
    # Code here
    temp=head
    itr=head
    while itr:
        if itr.next==temp:
            return 1
        itr=itr.next
        
    return 0