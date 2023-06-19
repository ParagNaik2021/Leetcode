**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion
class Solution {

   public static int f(int m, int n, int[][] grid) {
      if (m == 0 && n == 0) return grid[m][n];
      if (m < 0 || n < 0) return (int) Math.pow(10, 9);

      int up = grid[m][n] + f(m - 1, n, grid);
      int left = grid[m][n] + f(m, n - 1, grid);

      return Math.min(left, up);
   }

   public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      return f(m - 1, n - 1, grid);
   }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
     public static int f(int m,int n,int[][] dp,int[][] grid)
    {
        if(m==0 && n==0) return grid[m][n];
        if(m<0||n<0) return (int)Math.pow(10,5);
        if(dp[m][n]!=-1) return dp[m][n];

        int up=grid[m][n]+f(m-1,n,dp,grid);
        int left=grid[m][n]+f(m,n-1,dp,grid);

        return dp[m][n]=Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int[][] dp=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(m-1,n-1,dp,grid);
        
    }
}


***************************************Tabulation approach****************************************
//Tabulation
class Solution {

   public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m][n];
      for (int i = 0; i < m; i++) {

         for (int j = 0; j < n; j++) {

            if (i == 0 && j == 0) {
              dp[i][j]= grid[i][j];
            }
            else{

            int up = grid[i][j];
            if(i>0) up+=dp[i-1][j];
             else up += (int)Math.pow(10,9);

            int left = grid[i][j];
            if (j > 0)  left+=dp[i][j-1];
            else left+=(int) Math.pow(10,9);         

            dp[i][j] = Math.min(left, up);
            }
         }
      }
      return dp[m-1][n-1];
   }
}



***************************************Space optimization approach****************************************
//Space optimization
class Solution {
    public int minPathSum(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        for(int i=0;i<m;i++)
        {
            int[] temp=new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) temp[j]=grid[i][j];

                else{
                    int up=grid[i][j];
                    if(i>0) up+=prev[j];
                    else up+=(int)Math.pow(10,9);


                    int left=grid[i][j];
                    if(j>0) left+=temp[j-1];
                    else left+=(int)Math.pow(10,9);

                    temp[j]=Math.min(up,left);
                }
            }
            prev=temp;
        }
        return prev[n-1];
        
    }
}