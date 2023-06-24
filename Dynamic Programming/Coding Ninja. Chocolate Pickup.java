**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE

import java.util.* ;
import java.io.*; 
public class Solution {

	public static int f(int i,int j1,int j2,int r,int c,int[][] grid )
	{
		if(j1<0 || j2<0 || j1>=c || j2>=c)
		{
			return (int) Math.pow(-10,9);
		}
		if(i==r-1)
		{
			if(j1==j2) return grid[i][j1];
			else return grid[i][j1]+grid[i][j2];
		}

		int maxi=(int) Math.pow(-10,9);
		for(int dj1=-1;dj1<=+1;dj1++)
		{
			for(int dj2=-1;dj2<=+1;dj2++)
			{
				int value=0;
				if(j1==j2) value=grid[i][j1];
				else value=grid[i][j1]+grid[i][j2];
				value+=f(i+1,j1+dj1,j2+dj2,r,c,grid);
				maxi=Math.max(maxi,value);

			}
		}
		return maxi;
	}

	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		return f(0,0,c-1,r,c,grid);

	}
}

****************************Memoization approach***************************************************
//Memoization
import java.util.* ;
import java.io.*; 
public class Solution {

	public static int f(int i,int j1,int j2,int r,int c,int[][] grid,int[][][] dp )
	{
		if(j1<0 || j2<0 || j1>=c || j2>=c)
		{
			return (int) Math.pow(-10,9);
		}
		if(i==r-1)
		{
			if(j1==j2) return grid[i][j1];
			else return grid[i][j1]+grid[i][j2];
		}
		if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

		int maxi=(int) Math.pow(-10,9);
		for(int dj1=-1;dj1<=+1;dj1++)
		{
			for(int dj2=-1;dj2<=+1;dj2++)
			{
				int value=0;
				if(j1==j2) value=grid[i][j1];
				else value=grid[i][j1]+grid[i][j2];
				value+=f(i+1,j1+dj1,j2+dj2,r,c,grid,dp);
				maxi=Math.max(maxi,value);

			}
		}
		return dp[i][j1][j2]=maxi;
	}

	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int dp[][][]=new int[r][c][c];
		for(int row1[][]:dp)
		{
			for(int row2[]:row1)
			{
				Arrays.fill(row2,-1);
			}
		}


		return f(0,0,c-1,r,c,grid,dp);

	}
}

***************************************Tabulation approach****************************************
//Tabulation
import java.util.*;
import java.io.*;
public class Solution {

   public static int maximumChocolates(int n, int m, int[][] grid) {
      // Write your code here.
      int dp[][][] = new int[n][m][m];

      //base case
      for (int j1 = 0; j1 < m; j1++) {
         for (int j2 = 0; j2 < m; j2++) {
            if (j1 == j2)
               dp[n - 1][j1][j2] = grid[n - 1][j1];
            else
               dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
         }
      }

      for (int i = n - 2; i >= 0; i--) {
         for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
               int maxi = (int) Math.pow(-10, 9);
               for (int dj1 = -1; dj1 <= +1; dj1++) {
                  for (int dj2 = -1; dj2 <= +1; dj2++) {
                     int value = 0;
                     if (j1 == j2) value = grid[i][j1];
                     else value = grid[i][j1] + grid[i][j2];
                     if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) value += dp[i + 1][j1 + dj1][j2 + dj2];
                     else value += (int) Math.pow(-10, 9);
                     maxi = Math.max(maxi, value);

                  }
               }

               return dp[i][j1][j2] = maxi;
            }
         }
      }

      return dp[0][0][m - 1];

   }
}

***************************************Space optimization approach****************************************
//Space optimization
import java.util.* ;
import java.io.*; 
public class Solution {

	public static int maximumChocolates(int n, int m, int[][] grid) {
		// Write your code here.
		int front[][]=new int[m][m];
		int curr[][]=new int[m][m];
		//base case
		for(int j1=0;j1<m;j1++)
		{
			for(int j2=0;j2<m;j2++)
			{
				if(j1==j2) 
				front[j1][j2]=grid[n-1][j1];
				else
				 front[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
			}
		}
		
		for(int i=n-2;i>=0;i--)
		{
			for(int j1=0;j1<m;j1++)
			{
				for(int j2=0;j2<m;j2++)
				{
					int maxi=(int) Math.pow(-10,9);
					for(int dj1=-1;dj1<=+1;dj1++)
					{
						for(int dj2=-1;dj2<=+1;dj2++)
						{
							int value=0;
							if(j1==j2) value=grid[i][j1];
							else value=grid[i][j1]+grid[i][j2];
							if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m) value+=front[j1+dj1][j2+dj2];
							else value+=(int) Math.pow(-10,9);
							maxi=Math.max(maxi,value);

						}
					}

		 			curr[j1][j2]=maxi;
				}
			}
			 for (int a = 0; a < m; a++) {
        front[a] = (int[])(curr[a].clone());
      }
		}

		

return front[0][m-1];
		

	}
}