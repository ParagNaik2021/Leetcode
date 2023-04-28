***************************************************Optimal Solution*****************************************

class Solution
{
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
    
    public static Node addOne(Node head) 
    { 
        //code here.
        Node temp = reverse(head);
        Node cur = temp;
        while(cur.next != null){
            if(cur.data == 9)
                cur.data = 0;
            else{
                cur.data += 1;
                break;
            }
            cur = cur.next;
        }
        if(cur.next == null)
            cur.data += 1; // one node will have 10 i.e 9->9>9 -->10->0->0
        
        temp = reverse(temp);
        return temp;
    }
}