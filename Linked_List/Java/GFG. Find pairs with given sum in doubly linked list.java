********************Optimal Solution****************************************

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Node itr=head;
        Node left=head;
        Node curr=head;
        while(itr.next!=null)
        {
            itr=itr.next;
        }
        Node right=itr;
        
        while(left.data < right.data)
        {
            int sum=left.data+right.data;
            if(sum==target)
            {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(left.data);
                l.add(right.data);
                result.add(l);
                left=left.next;
                right=right.prev;
                
            }
            else if(sum<target) left=left.next;
            
            else right=right.prev;
        }
        
     return result;   
    }
}
        
