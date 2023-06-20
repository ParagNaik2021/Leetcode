**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int f(int i,int j,int[][] mat)
	{
		if(j<0 || j>=mat[0].length) return (int) Math.pow(-10,9);
		if(i==0) return mat[0][j];
		int up=mat[i][j]+f(i-1,j,mat);
		int left=mat[i][j]+f(i-1,j-1,mat);
		int right=mat[i][j]+f(i-1,j+1,mat);
	
		return Math.max(up,Math.max(left,right));

	}
	public static int getMaxPathSum(int[][] matrix) {
	
	int n=matrix.length;
	int m=matrix[0].length;
	int maxi=(int) Math.pow(-10,9);
	for(int j=0;j<m;j++)
	{
		maxi=Math.max(maxi, f(n-1,j,matrix));
	}
	return maxi;
	}
}


****************************Memoization approach***************************************************
//Memoization

import java.util.*;
import java.io.*;

//Memoization
public class Solution {
   public static int f(int i, int j, int[][] mat, int[][] dp) {
      if (j < 0 || j >= mat[0].length) return (int) Math.pow(-10, 9);
      if (i == 0) return mat[0][j];
      if (dp[i][j] != -1) return dp[i][j];

      int up = mat[i][j] + f(i - 1, j, mat, dp);
      int left = mat[i][j] + f(i - 1, j - 1, mat, dp);
      int right = mat[i][j] + f(i - 1, j + 1, mat, dp);

      return dp[i][j] = Math.max(up, Math.max(left, right));

   }
   public static int getMaxPathSum(int[][] matrix) {

      int n = matrix.length;
      int m = matrix[0].length;
      int[][] dp = new int[n][m];
      for (int[] row: dp) {
         Arrays.fill(row, -1);
      }

      int maxi = (int) Math.pow(-10, 9);
      for (int j = 0; j < m; j++) {
         maxi = Math.max(maxi, f(n - 1, j, matrix, dp));
      }
      return maxi;
   }
}

***************************************Tabulation approach****************************************
//Tabulation
import java.util.*;
import java.io.*;

//tabulation
public class Solution {

   public static int getMaxPathSum(int[][] mat) {

      int n = mat.length;
      int m = mat[0].length;
      int[][] dp = new int[n][m];
      //insert 1st row element from mat in dp
      for (int j = 0; j < m; j++) {
         dp[0][j] = mat[0][j];
      }
      //omit 1st row so i will start from 1
      for (int i = 1; i < n; i++) {
         for (int j = 0; j < m; j++) {

            int up = mat[i][j] + dp[i - 1][j];

            int left = mat[i][j];
            if (j - 1 >= 0) left += dp[i - 1][j - 1];
            else left += (int) Math.pow(-10, 9);

            int right = mat[i][j];
            if (j + 1 < m) right += dp[i - 1][j + 1];
            else right += (int) Math.pow(-10, 9);

            dp[i][j] = Math.max(up, Math.max(left, right));
         }
      }

      int maxi = (int) Math.pow(-10, 9);
      for (int j = 0; j < m; j++) {
         maxi = Math.max(maxi, dp[n - 1][j]);
      }
      return maxi;
   }
}


***************************************Space optimization approach****************************************
//Space optimization
import java.util.* ;
import java.io.*; 


//Memoization
public class Solution {
	
	public static int getMaxPathSum(int[][] mat) {
	
	int n=mat.length;
	int m=mat[0].length;
	int[] prev=new int[m];
	//insert 1st row element from mat in dp
	for(int j=0;j<m;j++)
	{
		prev[j]=mat[0][j];
	}
	//omit 1st row so i will start from 1
	for(int i=1;i<n;i++)
	{
		int[] curr=new int[m];
		for(int j=0;j<m;j++)
		{
	

      int up = mat[i][j] + prev[j];
      
	  int left = mat[i][j];
	  if(j-1>=0) left+=prev[j-1];
	  else left+=(int) Math.pow(-10,9);

      int right = mat[i][j];
	  if(j+1<m) right+=prev[j+1];
	  else right+=(int) Math.pow(-10,9);

       curr[j] = Math.max(up, Math.max(left, right));
		}
		prev=curr;
	}



	int maxi=(int) Math.pow(-10,9);
	for(int j=0;j<m;j++)
	{
		maxi=Math.max(maxi, prev[j]);
	}
	return maxi;
	}
}