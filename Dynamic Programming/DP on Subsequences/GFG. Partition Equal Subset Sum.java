**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
//Recurrsion
class Solution{
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
        return take || nottake;

    } 
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totSum=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            totSum+=arr[i];
        }
       
        if(totSum % 2==1) return 0;
        else{
             int target=totSum/2;
             if(f(n-1,target,arr)==true)
            return 1;
            else 
            return 0;  
        }
        
           
                
        }
   
    
}

****************************Memoization approach***************************************************
//Memoization
class Solution{
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
            take=f(index-1,target-arr[index],arr,dp);
        
        
         if(nottake==true || take==true)
            dp[index][target]=1;
        else
            dp[index][target]=0;
        
        return take || nottake;

    } 
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totSum=0;
        int n=arr.length;
       
        for(int i=0;i<n;i++)
        {
            totSum+=arr[i];
        }
        int[][] dp=new int[n][totSum/2+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        if(totSum % 2==1) return 0;
        else{
             int target=totSum/2;
             if(f(n-1,target,arr,dp)==true)
                return 1;
            else 
                return 0;  
        }
        
           
                
        }
   
    
}

***************************************Tabulation approach****************************************
//Tabulation
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// User function Template for Java
//Memoization
class Solution{
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
            take=f(index-1,target-arr[index],arr,dp);
        
        
         if(nottake==true || take==true)
            dp[index][target]=1;
        else
            dp[index][target]=0;
        
        return take || nottake;

    } 
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totSum=0;
        int n=arr.length;
       
        for(int i=0;i<n;i++)
        {
            totSum+=arr[i];
        }
        
        //for(int[] row:dp) Arrays.fill(row,-1);
        if(totSum % 2==1) return 0;
        else{
            int k=totSum/2;
            boolean[][] dp=new boolean[n][k+1];
            for(int i=0;i<n;i++) dp[i][0]=true;
            if(arr[0]<=k) dp[0][arr[0]]=true;
            
            for(int index=1;index<n;index++)
            {
                for(int target=1;target<=k;target++)
                {
                    boolean nottake=dp[index-1][target];
                    boolean take=false;
                    if(arr[index]<=target)
                        take=dp[index-1][target-arr[index]];
                        
                    if(nottake==true|| take==true) dp[index][target]=true;
                    else dp[index][target]=false;
                }
            }
            if(dp[n-1][k]==true) return 1;
            else return 0;
        }
        
           
                
        }
   
    
}


***************************************Space optimization approach****************************************
//Space optimization
