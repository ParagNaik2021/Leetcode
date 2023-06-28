**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
class Solution 
{ 
    public static int f(int W,int[] wt, int[] val, int n)
    {
        //base case
        if(n==0) 
        {
            if(wt[0]<=W) return val[0];
            else return 0;
        }
        int notTake=0+f(W,wt,val,n-1);
        int take=(int) Math.pow(-10,9);
        if(wt[n]<=W) take=val[n]+f(W-wt[n],wt,val,n-1);
        
        return Math.max(notTake,take);
        
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        return f(W,wt,val,n-1);
        
    } 
}


****************************Memoization approach***************************************************
//Memoization
class Solution 
{ 
    public static int f(int W,int[] wt, int[] val, int n,int[][] dp)
    {
        //base case
        if(n==0) 
        {
            if(wt[0]<=W) return val[0];
            else return 0;
        }
        if(dp[n][W]!=-1) return dp[n][W];
        
        int notTake=0+f(W,wt,val,n-1,dp);
        int take=(int) Math.pow(-10,9);
        if(wt[n]<=W) take=val[n]+f(W-wt[n],wt,val,n-1,dp);
        
        return dp[n][W]=Math.max(notTake,take);
        
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        
         int[][] dp=new int[n][W+1];
		for(int row[]: dp)
    		Arrays.fill(row,-1);
        return f(W,wt,val,n-1,dp);
        
    } 
}


***************************************Tabulation approach****************************************
//Tabulation
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        
         int[][] dp=new int[n][W+1];
		//base case
		for(int i=wt[0];i<=W;i++) dp[0][i]=val[0];
		
		for(int ind=1;ind<n;ind++)
		{
		    for(int cap=0;cap<=W;cap++)
		    {
		        int notTaken=0+dp[ind-1][cap];
		        int taken=(int) Math.pow(-10,9);
		        if(wt[ind]<=cap) taken=val[ind]+dp[ind-1][cap-wt[ind]];
		        
		        dp[ind][cap]=Math.max(notTaken,taken);
		    }
		}
	
	return dp[n-1][W];
        
    } 
}





***************************************Space optimization approach****************************************
//Space optimization
