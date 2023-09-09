####################################Optimal approach#########################################################
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxi=0;
        int counter=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                counter++;
                maxi=Math.max(counter,maxi);
                
            }
            else
            {
                counter=0;
            }

        }
        return maxi;
        
    }
}


Note-There is no brute or better apprach so move directly to optimal solution