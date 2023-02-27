class Solution {
    public void isSubset(int index, List<List<Integer>> result,List<Integer> ds,int[] nums)
    {
        result.add(new ArrayList<>(ds));
        for(int i=index;i<nums.length;i++)
        {
            if(i>index && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            isSubset(i+1,result,ds,nums);
            ds.remove(ds.size()-1);

        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        isSubset(0,result,new ArrayList<Integer>(),nums);
        return result;
    }
}