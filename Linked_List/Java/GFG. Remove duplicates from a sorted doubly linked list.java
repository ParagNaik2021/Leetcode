***************************Optimal Solution*******************************8

class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        if(head.next==null) return head;
       Node itr=head;
       Node curr=head;
       
       while(curr!=null)
       {
           if(curr.data!=itr.data)
           {
               itr.next=curr;
               curr.prev=itr;
               itr=curr;
           }
           curr=curr.next;
       }
       itr.next=null;
       return head;
    }
}