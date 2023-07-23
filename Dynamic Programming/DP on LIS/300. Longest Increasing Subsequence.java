**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
    public int f(int ind,int n,int[] nums,int ans,int prev_index)
    {
        if(ind==n) return 0;
        //int notTake=f(ind+1,n,nums,ans);
        if(prev_index==-1|| nums[ind]>nums[ind-1] )  ans=1+f(ind+1,n,nums,ans,prev_index+1);
        else  ans=f(ind+1,n,nums,ans,prev_index+1);
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        //int[] ans=new int[1];
        int ans=0;
        int prev_index=-1;
        int n=nums.length;
        return f(0,n,nums,ans,prev_index);   
    }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
  public static int f(int ind,int n,int[] nums,int prev_index,int[][] dp)
    {
      if(ind==n) return 0;
      if(dp[ind][prev_index+1]!=-1) return dp[ind][prev_index+1];
      int notTake=0+f(ind+1,n,nums,prev_index,dp);
        int take=0;
        if(prev_index==-1 || nums[ind]>nums[prev_index])
            take=1+f(ind+1,n,nums,ind,dp);
        return dp[ind][prev_index+1]=Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] arr) {
        int prev_index=-1;
		int n=arr.length;
		int[][] dp=new int[n][n+1];
		for(int[] row:dp)
		Arrays.fill(row,-1);
        return f(0,n,arr,prev_index,dp);
    }
}

***************************************Tabulation approach****************************************
//Tabulation

   


***************************************Space optimization approach****************************************
//Space optimization
