class gfg
{
        // Function  to split a circular LinkedList
        void splitList(circular_LinkedList list)
        {
             //DO NOT REMOVE THESE 3 LINES
             Node head=list.head;
             Node head1=null;
             Node head2=null;
             
             //Modify these head1 and head2 here, head is the starting point of our original linked list.    
           
             Node slow=head;
             Node fast=head.next;
             
             while(fast!=head && fast.next!=head)
             {
                 slow=slow.next;
                 fast=fast.next.next;
             }
             
             head1=head;
             head2=slow.next;
             slow.next=head1;
             
             Node curr=head2;
             while(curr.next!=head) curr=curr.next;
        
             curr.next=head2;
             
             
             //DO NOT REMOVE THESE 2 LINES
             list.head1=head1;
             list.head2=head2;
     }
}