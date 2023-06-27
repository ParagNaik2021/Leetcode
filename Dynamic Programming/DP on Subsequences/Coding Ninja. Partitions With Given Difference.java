**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE


****************************Memoization approach***************************************************
//Memoization
import java.util.* ;
import java.io.*; 

//Memoization
public class Solution {


public static int f(int ind,int sum,int[] arr,int[][] dp)
{
	//int mod=(int) math.pow(10,9)+7;
	if(ind == 0){
		if(sum==0 && arr[0]==0)
			return 2;
		if(sum==0 || sum == arr[0])
			return 1;
		return 0;
            }

	if(dp[ind][sum]!=-1) return dp[ind][sum];

	int notTake=f(ind-1,sum,arr,dp);
	int take=0;
	if(arr[ind]<=sum) take=f(ind-1,sum-arr[ind],arr,dp);


	return dp[ind][sum]=(notTake+take)%(int) (Math.pow(10,9)+7);
}


	public static int findWays(int[] nums,int tar)
	{
		int n=nums.length;
		int[][] dp=new int[n][tar+1];
		for(int row[]: dp)
    		Arrays.fill(row,-1);
	return f(n-1,tar,nums,dp);
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
}


***************************************Tabulation approach****************************************
//Tabulation
import java.util.* ;
import java.io.*; 

//tabulation
public class Solution {

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

                dp[ind][sum]=(take+notTake)%(int) (Math.pow(10,9)+7);
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
}

   


***************************************Space optimization approach****************************************
//Space optimization
import java.util.* ;
import java.io.*; 

//space optimization
public class Solution {

	public static int findWays(int[] nums,int tar)
	{
		int n=nums.length;
		int[] prev=new int[tar+1];
		if(nums[0]==0) prev[0]=2;
		else prev[0]=1;

		if(nums[0]!=0 && nums[0]<=tar) prev[nums[0]]=1;

		for(int ind=1;ind<n;ind++)
		{
			int[] curr=new int[tar+1];
			for(int sum=0;sum<=tar;sum++)
			{
				int notTake=prev[sum];
				int take=0;
				if(nums[ind]<=sum) take=prev[sum-nums[ind]];

				curr[sum]=(take+notTake)%(int) (Math.pow(10,9)+7);
			}
			prev=curr;
		}
		return prev[tar];
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
}