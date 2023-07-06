**********************************Recurssion- Coint Change but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE

//Recurrsion
class Solution {
    int f(int ind,int t,int[] coins)
    {
       if(ind==0)
       { if(t%coins[0]==0)
         return t/coins[0];
        else 
        return  (int) Math.pow(10,9);
        }
        int notTake=0+f(ind-1,t,coins);
        int take=(int) Math.pow(10,9);
        if(coins[ind]<=t) take=1+f(ind,t-coins[ind],coins);

        return Math.min(notTake,take);

    }

    public int coinChange(int[] coins, int amount) {

     int n=coins.length;
   
    int ans= f(n-1,amount,coins);
    if(ans>=(int) Math.pow(10,9)) return -1;

    return ans;

    }
}

****************************Memoization approach***************************************************
//Memoization

//Memoization
class Solution {
    int f(int ind,int t,int[] coins,int[][] dp)
    {
       if(ind==0)
       { if(t%coins[0]==0)
         return t/coins[0];
        else 
        return  (int) Math.pow(10,9);
        }
        if(dp[ind][t]!=-1) return dp[ind][t];
        int notTake=0+f(ind-1,t,coins,dp);
        int take=(int) Math.pow(10,9);
        if(coins[ind]<=t) take=1+f(ind,t-coins[ind],coins,dp);

        return dp[ind][t]=Math.min(notTake,take);

    }

    public int coinChange(int[] coins, int amount) {

     int n=coins.length;
    int[][] dp=new int[n][amount+1];
    for(int[] row:dp) Arrays.fill(row,-1);
    int ans= f(n-1,amount,coins,dp);
    if(ans>=(int) Math.pow(10,9)) return -1;

    return ans;

    }
}

***************************************Tabulation approach****************************************
//Tabulation

//tabulation
class Solution {
  

    public int coinChange(int[] coins, int amount) {

     int n=coins.length;
    int[][] dp=new int[n][amount+1];
    for(int[] row:dp) Arrays.fill(row,-1);

    for(int t=0;t<=amount;t++)
    {
        if(t%coins[0]==0) dp[0][t]=t/coins[0];
        else dp[0][t]=(int) Math.pow(10,9);
    }

    for(int ind=1;ind<n;ind++)
    {
        for(int T=0;T<=amount;T++)
        {
        int notTake=0+dp[ind-1][T];
        int take=(int) Math.pow(10,9);
        if(coins[ind]<=T) take=1+dp[ind][T-coins[ind]];

        dp[ind][T]=Math.min(notTake,take);
        }
    }

    int ans= dp[n-1][amount];
    if(ans>=(int) Math.pow(10,9)) return -1;

    return ans;

    }
}
   


***************************************Space optimization approach****************************************
//Space optimization

//space optimization
class Solution {
  

    public int coinChange(int[] coins, int amount) {

     int n=coins.length;
    int[] prev=new int[amount+1];
    int[] curr=new int[amount+1];

    for(int t=0;t<=amount;t++)
    {
        if(t%coins[0]==0) prev[t]=t/coins[0];
        else prev[t]=(int) Math.pow(10,9);
    }

    for(int ind=1;ind<n;ind++)
    {
         
        for(int T=0;T<=amount;T++)
        {
        int notTake=0+prev[T];
        int take=(int) Math.pow(10,9);
        if(coins[ind]<=T) take=1+prev[T-coins[ind]];

        curr[T]=Math.min(notTake,take);
        }
        prev=curr;
    }

    int ans=prev[amount];
    if(ans>=(int) Math.pow(10,9)) return -1;

    return ans;

    }
}