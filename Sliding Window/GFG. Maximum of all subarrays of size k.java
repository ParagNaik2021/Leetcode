########################## Sliding Window #############################################

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayDeque<Integer> Q=new ArrayDeque<>();
        int start=0;
        int end=0;
        int maxi=Integer.MIN_VALUE;
        while(end<n){
            //calculation
            while(!Q.isEmpty() && Q.getLast()<arr[end]){
                Q.removeLast();
            }
            
            Q.offer(arr[end]);
            
            if(end-start+1<k){
                
                end++;
                
            }
            else if(end-start+1==k){
                ans.add(Q.peek());
                
                if(Q.getFirst()==arr[start]){
                    Q.removeFirst();
                }
                
                  end++;
                  start++;
            }
        }
        return ans;
    }
}