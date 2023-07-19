**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
    public int f(int ind,int buy,int[] prices,int n)
    {
        //base case
        if(ind==prices.length) return 0;
        int profit=0;
        if(buy==1)
        {
            profit=Math.max((-prices[ind]+f(ind+1,0,prices,n)),(0+f(ind+1,1,prices,n)));
        }
        else{
                profit=Math.max((prices[ind]+f(ind+1,1,prices,n)),(0+f(ind+1,0,prices,n)));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=1;
       

        return f(0,buy,prices,n);
    }
}

****************************Memoization approach***************************************************
//Memoization

class Solution {
    public int f(int ind,int buy,int[] prices,int n,int[][] dp)
    {
        //base case
        if(ind==prices.length) return 0;
        int profit=0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1)
        {
            profit=Math.max((-prices[ind]+f(ind+1,0,prices,n,dp)),(0+f(ind+1,1,prices,n,dp)));
        }
        else{
                profit=Math.max((prices[ind]+f(ind+1,1,prices,n,dp)),(0+f(ind+1,0,prices,n,dp)));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=1;
        int[][] dp=new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);

        return f(0,buy,prices,n,dp);
    }
}

***************************************Tabulation approach****************************************
//Tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
    
        int[][] dp=new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                int profit=0;
                if(buy==1)
                    profit=Math.max(-prices[ind]+dp[ind+1][0],0+dp[ind+1][1]);

                else
                    profit=Math.max(prices[ind]+dp[ind+1][1],0+dp[ind+1][0]);
                dp[ind][buy]=profit;
            }
        }

        return dp[0][1];
    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
    
        int[] ahead=new int[2];
       int[] curr=new int[2];
        
        ahead[0]=0;
        ahead[1]=0;

        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                int profit=0;
                if(buy==1)
                    profit=Math.max(-prices[ind]+ahead[0], 0+ahead[1]);

                else
                    profit=Math.max(prices[ind]+ahead[1],0+ahead[0]);
                curr[buy]=profit;
            }
            ahead=curr;
        }

        return ahead[1];
    }
}


***************************************Variable approach****************************************

class Solution {
    public int maxProfit(int[] prices) {
        int aheadNotBuy=0;
        int aheadBuy=0;
        int currBuy=0;
        int currNotBuy=0;
        int n=prices.length;
        for(int ind=n-1;ind>=0;ind--)
        {
            currNotBuy=Math.max((prices[ind]+aheadBuy),(0+aheadNotBuy));

            currBuy=Math.max((-prices[ind]+aheadNotBuy),(0+aheadBuy));

            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }
}