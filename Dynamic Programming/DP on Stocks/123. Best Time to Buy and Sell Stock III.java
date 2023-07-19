**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
    public static int f(int ind,int buy,int[] prices,int cap,int n)
    {
        if(cap==0) return 0;

        if(ind==n) return 0;

        int profit=0;
        if(buy==1)
            profit=Math.max((-prices[ind]+f(ind+1,0,prices,cap,n)),(0+f(ind+1,1,prices,cap,n)));
        else
            profit=Math.max((prices[ind]+f(ind+1,1,prices,cap-1,n)),(0+f(ind+1,0,prices,cap,n)));
        return profit;
            
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=1;
        int cap=2;
        return f(0,buy,prices,cap,n);

    }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
    public static int f(int ind,int buy,int[] prices,int cap,int n,int[][][] dp)
    {
        if(cap==0) return 0;

        if(ind==n) return 0;

        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

        int profit=0;
        if(buy==1)
            profit=Math.max((-prices[ind]+f(ind+1,0,prices,cap,n,dp)),(0+f(ind+1,1,prices,cap,n,dp)));
        else
            profit=Math.max((prices[ind]+f(ind+1,1,prices,cap-1,n,dp)),(0+f(ind+1,0,prices,cap,n,dp)));
        return dp[ind][buy][cap]=profit;
            
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=1;
        int cap=2;
        int[][][] dp=new int[n+1][2][3];
        for (int i = 0; i <= n; i++) {
        for (int j = 0; j < 2; j++) {
            Arrays.fill(dp[i][j], -1);
        }
}
        return f(0,buy,prices,cap,n,dp);

    }
}

***************************************Tabulation approach****************************************
//Tabulation
//tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
  
        int[][][] dp=new int[n+1][2][3];

        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=2;cap++)
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
        return dp[0][1][2];

    }
}
   


***************************************Space optimization approach****************************************
//Space optimization

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
  
     int [][] after=new int[2][3];
      int [][] curr=new int[2][3];
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=2;cap++)
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
        return after[1][2];

    }
}