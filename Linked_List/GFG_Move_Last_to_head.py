def Move_last_element_1(self):
    if self.head==None or self.head.next==None:
        return self.head
    
    itr=self.head
    curr1=None
    while itr.next!=None:
        curr1=itr
        itr=itr.next
        
    itr.next=self.head
    curr1.next=None
    self.head=itr
    return "Last is 1st"
    