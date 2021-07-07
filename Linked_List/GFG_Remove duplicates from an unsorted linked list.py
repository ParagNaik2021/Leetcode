Approach-1(hashset)

class Solution:
    #Function to remove duplicates from unsorted linked list.
    def removeDuplicates(self, head):
        # code here
        # return head after editing list
        Hashset=set()
        prev,itr=head,head
        
        while itr!=None:
            if itr.data in Hashset:
                prev.next=itr.next
            else:
                Hashset.add(itr.data)
                prev=itr
            itr=itr.next
        return head


Approach-2(two pointer)


def removeDuplicates(self,head):   
        ptr1 = None
        ptr2 = None
        dup = None
        ptr1 = head

		while (ptr1 != None and ptr1.next != None):
		             
		            ptr2 = ptr1
		 
		                # Compare the picked element with rest
		                # of the elements
            while (ptr2.next != None):
                 
                # If duplicate then delete it
                if (ptr1.data == ptr2.next.data):
                         
                    # Sequence of steps is important here
                    dup = ptr2.next
                    ptr2.next = ptr2.next.next
                else:
                    ptr2 = ptr2.next
                     
            ptr1 = ptr1.next
             
        return head