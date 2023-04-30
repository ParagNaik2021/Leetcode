*******************************Optimal Solution*********************************8
TC-->O(N)
SC-->O(N)-->Hashing


class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
         // Your code here
         Node curr=head;
         Node prev=head;
         
         if(curr==null || curr.next==null) return curr;
         
         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         
         map.put(curr.data,1);
         
         curr=curr.next;
         
         while(curr!=null)
         {
             if(map.containsKey(curr.data))
             {
                 prev.next=curr.next;
                 curr=curr.next;
             }
             else{
                 
                 map.put(curr.data,1);
                 prev=prev.next;
                 curr=curr.next;
             }
 
         }
 
        return head;        
         
    }
}

