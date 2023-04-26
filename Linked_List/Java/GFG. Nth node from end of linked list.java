**********************************************************Optimized Approach*************************************************************

class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
        // Your code here
        Node dummy=new Node(0);
        dummy.next=head;
        Node fast=dummy;
        Node slow=dummy;
        
        for(int i=1;i<=n;i++)
        {
            if(fast==null || fast.next==null) return -1;
            fast=fast.next;
        }
        
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        
        
        return slow.next.data;
    }
}


Time Complexity: O(N)

Space Complexity: O(1)