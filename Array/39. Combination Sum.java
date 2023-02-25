class Solution {
    public void isCombiSubset(int index,List<List<Integer>> result,List<Integer> ds,int[] arr, int target)
    {
        if(index==arr.length)
        {
            if(target==0)
            {
                result.add(new ArrayList<>(ds));
            }
            return;
            
        }
        //index,result,ds,arr,target
        if(arr[index]<=target)
        {
                ds.add(arr[index]);
                isCombiSubset(index,result,ds,arr,target-arr[index]);//no need to index+1 as we are checking if same element can be used not restiration on how many we can use
                ds.remove(ds.size()-1);
        }

        isCombiSubset(index+1,result,ds,arr,target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        int index=0;
        isCombiSubset(index,result,new ArrayList<>(),candidates,target);
        return result;

    }
}