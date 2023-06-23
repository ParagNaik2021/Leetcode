**********************************Recurssion-  but time limit exceed *****************************************
//Recurrssion--->TLE

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean f(int index,int target,int[] arr)
    {
        if(target==0) return true;
        if(index==0) return (arr[0]==target);

        boolean nottake=f(index-1,target,arr);
        boolean take=false;

        if(arr[index]<=target)
        {
            take=f(index-1,target-arr[index],arr);
        }
        return take | nottake;

    } 
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        return f(n-1,k,arr);
    }
}



****************************Memoization approach***************************************************
//Memoization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean f(int index,int target,int[] arr,int[][] dp)
    {
        if(target==0) return true;
        if(index==0) return (arr[0]==target);

        if(dp[index][target]!=-1)
        {
            
            if(dp[index][target]==0)
                return false;
            else 
                return true;
        }

        boolean nottake=f(index-1,target,arr,dp);
        boolean take=false;

        if(arr[index]<=target)
        {
            take=f(index-1,target-arr[index],arr,dp);
        }

        if(nottake==true || take==true)
            dp[index][target]=1;
        else
            dp[index][target]=0;

        //dp[index][target]=nottake||take?1:0;
        return nottake||take;

    } 
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp=new int[n][k+1];
        for(int[] row:dp) Arrays.fill(row,-1); 
        return f(n-1,k,arr,dp);
    }
}



***************************************Tabulation approach****************************************
//Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
   
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp=new boolean[n][k+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(arr[0]<=k)dp[0][arr[0]]=true;
        for(int index=1;index<n;index++)
        {
            for(int target=1;target<=k;target++)
            {
                boolean nottake=dp[index-1][target];
                boolean take=false;

                if(arr[index]<=target) take=dp[index-1][target-arr[index]];
                
                if(nottake==true || take==true)
                     dp[index][target]=true;
                else
                         dp[index][target]=false;
            }
        }
        return dp[n-1][k];
    }
}





***************************************Space optimization approach****************************************
//Space optimization
