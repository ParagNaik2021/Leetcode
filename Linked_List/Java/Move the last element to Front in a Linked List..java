**************************Coding Ninja************************************


public class Solution {
    public static  Node delAddLastNode(Node head) {
        // Write your code here.
        if(head==null||head.next==null) return head;
        Node itr=head;
        Node prev=new Node(0);
        prev.next=head;
        while(itr.next!=null)
        {
            prev=itr;
            itr=itr.next;
            
        }
        itr.next=head;
        prev.next=null;
        head=itr;
        return itr;


    }
}