class Solution{
    
    public void isSubsetSum(int index,ArrayList<Integer> arr,ArrayList<Integer> result,int sum,int N)
    {
        if(index==N)
        {
            result.add(sum);
            return ;
        }
        
        //pick
        isSubsetSum(index+1,arr,result,sum+arr.get(index),N);
        
        //not pick
        isSubsetSum(index+1,arr,result,sum,N);

    }
    
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        ArrayList<Integer> result=new ArrayList<>();
        int sum=0;
        int index=0;
        
        isSubsetSum(index,arr,result,sum,N);
        
        Collections.sort(result);
        return result;
        
        
        
        
        
    }
}