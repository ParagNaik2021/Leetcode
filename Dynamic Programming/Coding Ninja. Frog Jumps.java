**********************************Recurssion- Frog Jump*****************************************
import java.util.* ;
import java.io.*; 
// recurrsion solution
public class Solution {
    public static int f(int ind,int[] height)
    {
        if(ind==0) return 0;
        int left=f(ind-1,height)+Math.abs(height[ind]-height[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1) right=f(ind-2,height)+Math.abs(height[ind]-height[ind-2]);
        return Math.min(left,right);
    }
    public static int frogJump(int n, int heights[]) {

            return f(n-1,heights);
    }

}


****************************Memoization approach***************************************************
import java.util.* ;
import java.io.*; 
public class Solution {


    public static int f(int index,int[] height,int[] dp)
    {
        if(index==0) return 0;
        
        //if the value is visisted so we dont cal it just return
        if(dp[index]!=-1) return dp[index];
        
        int left=f(index-1, height, dp)+Math.abs(height[index]-height[index-1]);
        int right=Integer.MAX_VALUE;
        
        if(index>1) 
            right= f(index-2, height, dp)+Math.abs(height[index]-height[index-2]);
        
        return dp[index]=Math.min(left,right);
    }
    public static int frogJump(int n, int heights[]) {

    int[] dp=new int[n];
    Arrays.fill(dp, -1);
        return f(n-1,heights,dp);
    }
}

***************************************Tabulation approach****************************************
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int first_step=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int second_step=Integer.MAX_VALUE;
            if(i>1){
            second_step=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            }
            dp[i]=Math.min(first_step,second_step);
        }
        return dp[n-1];
    }

}

***************************************Space approach****************************************

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++)
        {
            int fs=prev+Math.abs(heights[i]-heights[i-1]);
            int ss=Integer.MAX_VALUE;
            if(i>1) ss=prev2+Math.abs(heights[i]-heights[i-2]);
            int curr_i=Math.min(fs,ss);
            prev2=prev;
            prev=curr_i;
        }
        return prev;
        
    }

}