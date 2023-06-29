**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
class Solution {
    public int f(int n,int target,int[] coins)
    {
        //base case
        if(n==0)
        {
            if(target%coins[0]==0) return 1;
            else return 0;
        }
        int notTake=f(n-1,target,coins);
        int take=0;
        if(target>=coins[n]) take=f(n,target-coins[n],coins);

        return notTake+take;

    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        return f(n-1,amount,coins);
        
    }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
    public int f(int n,int target,int[] coins,int[][] dp)
    {
        //base case
        if(n==0)
        {
            if(target%coins[0]==0) return 1;
            else return 0;
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int notTake=f(n-1,target,coins,dp);
        int take=0;
        if(target>=coins[n]) take=f(n,target-coins[n],coins,dp);

        return dp[n][target]=notTake+take;

    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);

        return f(n-1,amount,coins,dp);
        
    }
}

***************************************Tabulation approach****************************************
//Tabulation
class Solution {
    
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
       
       for(int i=0;i<=amount;i++)
       {
             if(i%coins[0]==0) dp[0][i]=1;
       }

      

       for(int ind=1;ind<n;ind++)
       {
           for(int T=0; T<=amount ;T++)
           {
               int notTake=dp[ind-1][T];
               int take=0;
               if(T>=coins[ind]) take=dp[ind][T-coins[ind]];

               dp[ind][T]=take+notTake;
           }
       }

        return dp[n-1][amount];
        
    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
class Solution {
    
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        
       
       for(int i=0;i<=amount;i++)
       {
             if(i%coins[0]==0) prev[i]=1;
       }
       for(int ind=1;ind<n;ind++)
       {
           int[] curr=new int[amount+1];
           for(int T=0; T<=amount ;T++)
           {
               int notTake=prev[T];
               int take=0;
               if(T>=coins[ind]) take=curr[T-coins[ind]];

               curr[T]=take+notTake;
           }
           prev=curr;
       }

        return prev[amount];
        
    }
}