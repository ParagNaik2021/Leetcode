**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion
import java.io.*;
class Solution {
    public int f(int m,int n,int[][] obstacleGrid)
    {
        if(m>=0 && n>=0 && obstacleGrid[m][n]==1) return 0;
        if(m==0 && n==0) return 1;

        if(m<0||n<0) return 0;

        int up=f(m-1,n,obstacleGrid);
        int left=f(m,n-1,obstacleGrid);

        return up+left;

   
        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        System.out.println(m+" "+n);
        return f(m-1,n-1,obstacleGrid);
    }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
    public int f(int m,int n, int[][] dp,int[][] obstacleGrid)
    {
        if(m==0 && n==0)  return 1;

        if(m>=0 && n>=0 && obstacleGrid[m][n]==1) return 0;

        if(m<0||n<0) return 0;

        if(dp[m][n]!=-1) return dp[m][n];


        int up=f(m-1,n,dp,obstacleGrid);
        int left=f(m,n-1,dp,obstacleGrid);

       return  dp[m][n]=up+left;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        System.out.println(m+" "+n);
        if(m==1 && n==1 && obstacleGrid[0][0]==1) return 0; //for test case 36 [[1]]
       if(obstacleGrid[0][0]==1) return 0; //for test case 37 [[1,0]]
        int[][] dp=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);


        return f(m-1,n-1,dp,obstacleGrid);

    }
}


***************************************Tabulation approach****************************************
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     int m=obstacleGrid.length;
     int n=obstacleGrid[0].length;
     int[][] dp=new int[m][n];
     for(int i=0;i<m;i++)
     {
         for(int j=0;j<n;j++)
         {
             if(obstacleGrid[i][j]==1) dp[i][j]=0;
             else if (i==0 && j==0) dp[i][j]=1;

             else{
                 int up=0;
                 int left=0;
                 if(i>0) up=dp[i-1][j];

                 if(j>0) left=dp[i][j-1];

                 dp[i][j]=up+left;
             }
         }
     }
     return dp[m-1][n-1];

    }
}


***************************************space optimazation approach****************************************


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] ==1) return 0;
        int[] prev = new int[col];

        for(int i = 0; i < row; i++) {
            int[] cur = new int[col];
            for(int j = 0; j < col; j++) {
                if(obstacleGrid[i][j] == 1){
                    cur[j] = 0;
                    continue;
                }
                if(i==0 && j==0) {
                    cur[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i > 0) {
                    up = prev[j];
                }
                if(j > 0) {
                    left = cur[j-1];
                }
                cur[j] = up+left;
            }
          
            prev = cur;

        }
        return prev[col-1];
    }
}