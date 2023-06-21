**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode
class Solution {

  public static int f(int i, int j, int n, List < List < Integer >> triangle) {
    if (i == n - 1) return triangle.get(n - 1).get(j);

    int down = triangle.get(i).get(j) + f(i + 1, j, n, triangle);
    int dia = triangle.get(i).get(j) + f(i + 1, j + 1, n, triangle);

    return Math.min(down, dia);
  }

  public int minimumTotal(List < List < Integer >> triangle) {
    int n = triangle.size();
    return f(0, 0, n, triangle);
  }
}


//Recurrssion-Coding Ninja
import java.util.* ;
import java.io.*; 
public class Solution {

    public static int f(int i,int j,int n,int[][] triangle)
    {
        if(i==n-1) return triangle[n-1][j];

        int down=triangle[i][j]+f(i+1,j,n,triangle);
        int dia=triangle[i][j]+f(i+1,j+1,n,triangle);

        return Math.min(down, dia);
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
   
        return f(0,0,n,triangle);
    }
}

****************************Memoization approach***************************************************
//Memoization
import java.util.* ;
import java.io.*; 
public class Solution {

  public static int f(int i,int j,int n,int[][] triangle,int[][] dp)
    {
        if(i==n-1) return triangle[n-1][j];

        if(dp[i][j]!=-1) return dp[i][j];

       int down=triangle[i][j]+f(i+1,j,n,triangle,dp);
       int dia=triangle[i][j]+f(i+1,j+1,n,triangle,dp);

        return dp[i][j]=Math.min(down, dia);
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
   
      int m= triangle.length;
        int n1= triangle[0].length;
        int[][] dp=new int[m][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(0,0,n,triangle,dp);
    }
}


***************************************Tabulation approach****************************************
//Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        
        int[][] dp=new int[n][n];
        for(int j=0;j<n;j++) dp[n-1][j]=triangle[n-1][j];
        //we will start from bottom and end at top
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down = triangle[i][j]+dp[i+1][j];
                int diagonal = triangle[i][j]+dp[i+1][j+1];
            
                 dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}

***************************************Space optimization approach****************************************
//Space optimization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
      int[] front =new int[n];
      for(int j=0;j<n;j++)
      {
        front[j]=triangle[n-1][j];
      }
      for(int i=n-2;i>=0;i--)
      {
        int[] curr=new int[n];
        for(int j=i;j>=0;j--)
        {
          int down=triangle[i][j]+front[j];
          int diagonal=triangle[i][j]+front[j+1];
          curr[j]=Math.min(down,diagonal);
        }
        front=curr;
      }
      return front[0];
        
    }
}