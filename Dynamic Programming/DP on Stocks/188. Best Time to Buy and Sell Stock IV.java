**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
    public static int f(int ind,int buy,int[] prices,int n,int k)
    {
        if(k==0) return 0;
        if(ind==n) return 0;
        int profit=0;
        if(buy==1) profit=Math.max((-prices[ind]+f(ind+1,0,prices,n,k)),(0+f(ind+1,1,prices,n,k)));
        else profit=Math.max((prices[ind]+f(ind+1,1,prices,n,k-1)),(0+f(ind+1,0,prices,n,k)));
        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;       
        return f(0,1,prices,n,k);
    }
}

****************************Memoization approach***************************************************
//Memoization

class Solution {
    public static int f(int ind,int buy,int[] prices,int n,int k,int[][][] dp)
    {
        if(k==0) return 0;
        if(ind==n) return 0;
        if(dp[ind][buy][k]!=-1) return dp[ind][buy][k];
        int profit=0;
        if(buy==1) profit=Math.max((-prices[ind]+f(ind+1,0,prices,n,k,dp)),(0+f(ind+1,1,prices,n,k,dp)));
        else profit=Math.max((prices[ind]+f(ind+1,1,prices,n,k-1,dp)),(0+f(ind+1,0,prices,n,k,dp)));
        return dp[ind][buy][k]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;     
        int[][][] dp=new int[n+1][2][k+1];  
        for (int i = 0; i <= n; i++) {
        for (int j = 0; j < 2; j++) {
            Arrays.fill(dp[i][j], -1);
        }
        }
        return f(0,1,prices,n,k,dp);
    }
}

***************************************Tabulation approach****************************************
//Tabulation

class Solution {
    public static int f(int ind,int buy,int[] prices,int n,int k,int[][][] dp)
    {
        if(k==0) return 0;
        if(ind==n) return 0;
        if(dp[ind][buy][k]!=-1) return dp[ind][buy][k];
        int profit=0;
        if(buy==1) profit=Math.max((-prices[ind]+f(ind+1,0,prices,n,k,dp)),(0+f(ind+1,1,prices,n,k,dp)));
        else profit=Math.max((prices[ind]+f(ind+1,1,prices,n,k-1,dp)),(0+f(ind+1,0,prices,n,k,dp)));
        return dp[ind][buy][k]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=k;cap++)
                {
                    if(buy==1)
                    {
                        dp[ind][buy][cap]=Math.max((-prices[ind]+dp[ind+1][0][cap]),(0+dp[ind+1][1][cap]));
                    }
                    else{
                        dp[ind][buy][cap]=Math.max((prices[ind]+dp[ind+1][1][cap-1]),(0+dp[ind+1][0][cap]));
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int [][] after=new int[2][k+1];
        int [][] curr=new int[2][k+1];
            for(int ind=n-1;ind>=0;ind--)
            {
                for(int buy=0;buy<=1;buy++)
                {
                    for(int cap=1;cap<=k;cap++)
                    {
                        if(buy==1)
                        {
                            curr[buy][cap]=Math.max((-prices[ind]+after[0][cap]),(0+after[1][cap]));
                        }
                        else{
                            curr[buy][cap]=Math.max((prices[ind]+after[1][cap-1]),(0+after[0][cap]));
                        }
                    }
                    after=curr;
                }
            }
        return after[1][k];
    }
}