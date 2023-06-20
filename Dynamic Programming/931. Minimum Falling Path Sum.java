**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode
//recurrsion
class Solution {

  public static int f(int i,int j,int[][] mat)
	{
		if(j<0 || j>=mat[0].length) return (int) Math.pow(10,9);
		if(i==0) return mat[0][j];
		int up=mat[i][j]+f(i-1,j,mat);
		int left=mat[i][j]+f(i-1,j-1,mat);
		int right=mat[i][j]+f(i-1,j+1,mat);
	
		return Math.min(up,Math.min(left,right));

	}
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        int mini=(int) Math.pow(10,9);
        for(int j=0;j<n;j++)
        {
            mini=Math.min(mini, f(n-1,j,matrix));
        }

        return mini;
    }
}


****************************Memoization approach***************************************************
//Memoization
//Memoization
class Solution {

  public static int f(int i,int j,int[][] mat,int[][] dp)
	{
		if(j<0 || j>=mat[0].length) return (int) Math.pow(10,9);
		if(i==0) return mat[0][j];
         if (dp[i][j] != -1) return dp[i][j];

		int up=mat[i][j]+f(i-1,j,mat,dp);
		int left=mat[i][j]+f(i-1,j-1,mat,dp);
		int right=mat[i][j]+f(i-1,j+1,mat,dp);
	
		return dp[i][j]=Math.min(up,Math.min(left,right));

	}
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp = new int[n][n];
      for (int[] row: dp) {
         Arrays.fill(row, -1);
      }

        int mini=(int) Math.pow(10,9);
        for(int j=0;j<n;j++)
        {
            mini=Math.min(mini, f(n-1,j,matrix,dp));
        }

        return mini;
    }
}

***************************************Tabulation approach****************************************
//Tabulation
//Memoization
class Solution {

    public int minFallingPathSum(int[][] mat) {
        int n=mat.length;
        int[][] dp = new int[n][n];
      
        for(int j=0;j<n;j++)
        {

            dp[0][j]=mat[0][j];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                 
            int up = mat[i][j] + dp[i - 1][j];

            int left = mat[i][j];
            if (j - 1 >= 0) left += dp[i - 1][j - 1];
            else left += (int) Math.pow(10, 9);

            int right = mat[i][j];
            if (j + 1 < n) right += dp[i - 1][j + 1];
            else right += (int) Math.pow(10, 9);

            dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }



        int mini=(int) Math.pow(10,9);
        for(int j=0;j<n;j++)
        {
            mini=Math.min(mini, dp[n-1][j]);
        }

        return mini;
    }
}

***************************************Space optimization approach****************************************
//Space optimization
