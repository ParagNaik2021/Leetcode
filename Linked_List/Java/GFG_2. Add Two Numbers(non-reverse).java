class Solution{
    
    public static Node reverse(Node head)
    {
     
        Node itr=head;
        Node prev=null;
        Node nex=null;

        while(itr!=null)
        {
            nex=itr.next;
            itr.next=prev;
            prev=itr;
            itr=nex;
        }
        return prev;
    }
    
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
            Node l1=reverse(first);
            Node l2=reverse(second);
            Node dummy=new Node(0);
            Node temp=dummy;
            int carry=0;
            while(l1!=null || l2!=null || carry==1)
            {
                int addition=0;
                if(l1!=null)
                {
                    addition+=l1.data;
                    l1=l1.next;
                }
                if(l2!=null)
                {
                    addition+=l2.data;
                    l2=l2.next;
                }
                addition+=carry;
                carry=addition/10;
                if(carry>0)
                {
                    addition=addition%10;
                }
               
                Node node = new Node(addition);
                temp.next=node;
                temp=temp.next;
           
            }
                return reverse(dummy.next);
     }
}