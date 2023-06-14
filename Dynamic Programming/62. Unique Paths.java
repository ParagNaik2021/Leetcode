**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrsion
class Solution {
    public int f(int m,int n,int[] path)
    {
        if(m==0 && n==0) return 1;

        if(m<0||n<0) return 0;

        int up=f(m-1,n,path);
        int left=f(m,n-1,path);

        path[0]=up+left;

        return path[0];
        
    }
    public int uniquePaths(int m, int n) {
        int[] path=new int[1];
        return f(m-1,n-1,path);
        
    }
}


****************************Memoization approach***************************************************
//Memoization
class Solution {
    public int f(int m,int n,int[][] dp)
    {
        if(m==0 && n==0) return 1;
        if(m<0||n<0) return 0;
         if(dp[m][n]!=-1) return dp[m][n];
        int up=f(m-1,n,dp);
        int left=f(m,n-1,dp);

     return  dp[m][n]=up+left;

     
        
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int [m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(m-1,n-1,dp);
        
    }
}



***************************************Tabulation approach****************************************


//Tabulation
class Solution {

  
    public int uniquePaths(int m, int n) {
      int[][] dp=new int[m][n];
      for (int[] row : dp)
        Arrays.fill(row, -1);

        for(int row=0;row<m;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(row==0 && col==0) 
                {
                    dp[row][col]=1;
                    continue;
                }
                  int up=0;
                  int down=0;
                  if(row>0)  up=dp[row-1][col];
                  if(col>0)  down=dp[row][col-1];
            
                dp[row][col]=up+down;
            }
        }
        return dp[m-1][n-1];
    }
}




***************************************space optimazation approach****************************************

class Solution {
   public int uniquePaths(int m, int n) {
      int[] prev = new int[n];
      for (int row = 0; row < m; row++) {
         int[] curr = new int[n];
         for (int col = 0; col < n; col++) {
            if (row == 0 && col == 0) curr[col] = 1;
            else {
               int up = 0;
               int left = 0;
               if (row > 0) {
                  up = prev[col];
               }
               if (col > 0) {
                  left = curr[col - 1];
               }
               curr[col] = up + left;
            }
         }
         prev = curr;
      }

      return prev[n - 1];
   }

}