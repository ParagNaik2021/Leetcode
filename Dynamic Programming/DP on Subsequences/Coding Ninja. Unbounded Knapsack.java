**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
class Solution{
    public static int f(int n,int maxwt,int[] val,int[] wt)
    {
        //base case
        if(n==0)
        {
            return maxwt/wt[0]*val[0];
        }
        
        int notTake=0+f(n-1,maxwt,val,wt);
        int take=0;
        if(wt[n]<=maxwt) take=val[n]+f(n,maxwt-wt[n],val,wt);
        
        
        return Math.max(take,notTake);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        return f(N-1,W,val,wt);
    }
}

****************************Memoization approach***************************************************
//Memoization
import java.util.* ;
import java.io.*; 

public class Solution {
    public static int f(int n,int maxwt, int[] val, int[] wt,int[][] dp)
    {
        //base case
        if(n==0)
        {
            return (int) maxwt/wt[0]*val[0];
        }

        if(dp[n][maxwt]!=-1) return dp[n][maxwt];

        int notTake=0+f(n-1,maxwt,val,wt,dp);
        int take=(int) Math.pow(-10,9);
        
        if(wt[n]<=maxwt) take=val[n]+f(n,maxwt-wt[n],val,wt,dp);
        return dp[n][maxwt]=Math.max(notTake,take);
    }
    public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
        int[][] dp=new int[n][w+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n-1,w,val,wt,dp);
    }
}


***************************************Tabulation approach****************************************
//Tabulation
public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
        int[][] dp=new int[n][w+1];
        for(int W=0;W<=w;W++) dp[0][W]=(int) (W/wt[0])*val[0];

        for(int ind=1;ind<n;ind++)
        {
            for(int W=0;W<=w;W++)
            {
                int notTake=0+dp[ind-1][W];
                int take=0;
                if(wt[ind]<=W)
                {
                    take=val[ind]+dp[ind][W-wt[ind]];
                }
                dp[ind][W]=Math.max(take,notTake);
            }
        }
        
        return dp[n-1][w];
    }
}
   


***************************************Space optimization approach---> 2D Array****************************************
//Space optimization
import java.util.* ;
import java.io.*; 

//Tabulation
public class Solution {
    
    public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
        int[] prev=new int[w+1];
         int[] curr=new int[w+1];
        for(int W=0;W<=w;W++) prev[W]=(int) (W/wt[0])*val[0];

        for(int ind=1;ind<n;ind++)
        {
            for(int W=0;W<=w;W++)
            {
                int notTake=0+prev[W];
                int take=0;
                if(wt[ind]<=W)
                {
                    take=val[ind]+curr[W-wt[ind]];
                }
                curr[W]=Math.max(take,notTake);
            }
            prev=curr;
        }
        
        return curr[w];
    }
}






***************************************Space optimization approach---> 1D Array****************************************
//Space optimization
import java.util.* ;
import java.io.*; 

//space optimization-single array
public class Solution {
    
    public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
        // Write your code here.
     int[] prev=new int[w+1];
        for(int W=0;W<=w;W++) prev[W]=(int) (W/wt[0])*val[0];

        for(int ind=1;ind<n;ind++)
        {
            for(int W=0;W<=w;W++)
            {
                int notTake=0+prev[W];
                int take=0;
                if(wt[ind]<=W)
                {
                    take=val[ind]+prev[W-wt[ind]];
                }
                prev[W]=Math.max(take,notTake);
            }
 
        }
        
        return prev[w];
    }
}
