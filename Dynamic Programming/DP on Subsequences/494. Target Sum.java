**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE


****************************Memoization approach***************************************************
//Memoization


***************************************Tabulation approach****************************************
//Tabulation
class Solution {
    public static int findWays(int[] nums,int tar)
    {
        int n=nums.length;
        int[][] dp=new int[n][tar+1];
        if(nums[0]==0) dp[0][0]=2;
        else dp[0][0]=1;

        if(nums[0]!=0 && nums[0]<=tar) dp[0][nums[0]]=1;

        for(int ind=1;ind<n;ind++)
        {
            for(int sum=0;sum<=tar;sum++)
            {
                int notTake=dp[ind-1][sum];
                int take=0;
                if(nums[ind]<=sum) take=dp[ind-1][sum-nums[ind]];

                dp[ind][sum]=(take+notTake);
            }
        }
        return dp[n-1][tar];
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int totSum=0;
        for(int i:arr) totSum+=i;
        if(totSum-d<0 ) return 0;
        if((totSum-d)%2==1) return 0;
        int s2=(totSum-d)/2;
        return findWays(arr,s2);
    }



    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length-1,target,nums);
    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
