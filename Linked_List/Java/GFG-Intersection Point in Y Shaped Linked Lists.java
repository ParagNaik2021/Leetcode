class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2)
    {
        if(head1==null || head2==null) return -1;
        
        Node itr1=head1;
        Node itr2=head2;
        
        while(itr1!=itr2)
        {
            if(itr1==null) itr1=head2;
            else itr1=itr1.next;
            
            if(itr2==null) itr2=head1;
            else itr2=itr2.next;
            
        }
        
        if(itr1!=null)
        {
            return itr1.data;
        }
        else
        {
            return -1;
        }
    }
}