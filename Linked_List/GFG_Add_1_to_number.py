def addOne(self,head):
    last=None
    itr=head
    while itr.next!=None:
        if itr.data!=9:
            last=itr
        itr=itr.next
    
    if itr.data !=9:
        itr.data+=1
        return head
    
    #9-9-9
    if last==None:
        last=Node(0)
        last.data=0
        last.next=head
        head=last
    
    
    last.data+=1
    last=last.next
    
    while last!=None:
        last.data=0
        last=last.next
    return head