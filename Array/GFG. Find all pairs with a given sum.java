Variation 3 of Two Sum from Leetcode but GFG Question

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here 
        ArrayList<pair> result=new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        
        int left=0;
        int right=(int)M-1;
        
        while(left<N && right>=0)
        {
            long sum=A[left]+B[right];
            if(sum==X)
            {
                result.add(new pair(A[left],B[right]));
                right--;
                left++;
            }
            else if(sum<X)
                left++;
        
            else
                right--;
                
        }
        
        //need to convert arraylist to pair array
        int n=result.size();
        pair[] p=new pair[n];
        for(int i=0;i<n;i++)
        {
            p[i]=new pair(result.get(i).first,
            result.get(i).second);
        }        
        return p;
        
    }
}