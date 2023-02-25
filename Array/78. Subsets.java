class Solution {

    public void isSubset(int index,List<List<Integer>> result,List<Integer> ds,int[] nums)
    {
        if(index==nums.length)
        {
            result.add(new ArrayList<>(ds));
            return ;
        }
        //Take the particular index
        ds.add(nums[index]);
        isSubset(index+1,result,ds,nums);
        ds.remove(ds.size()-1);

        //not pick
        isSubset(index+1,result,ds,nums);
    }

    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> result=new ArrayList<>();
        int index=0;
        isSubset(index,result,new ArrayList<>(),nums);
        return result;
    }
}