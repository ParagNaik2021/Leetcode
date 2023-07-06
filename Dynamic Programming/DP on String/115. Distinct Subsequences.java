**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
   public int f(int i, int j, String s, String t, int[][] dp) {
      //base case
      if (j < 0) return 1;
      if (i < 0) return 0;

      if (dp[i][j] != -1) return dp[i][j];

      if (s.charAt(i) == t.charAt(j)) return dp[i][j] = f(i - 1, j - 1, s, t, dp) + f(i - 1, j, s, t, dp);
      return dp[i][j] = f(i - 1, j, s, t, dp);
   }
   public int numDistinct(String s, String t) {
      int n = s.length();
      int m = t.length();
      int[][] dp = new int[n][m];
      for (int row[]: dp) Arrays.fill(row, -1);
      return f(n - 1, m - 1, s, t, dp);

   }
}

****************************Memoization approach***************************************************
//Memoization
class Solution {
   public int f(int i, int j, String s, String t, int[][] dp) {
      //base case
      if (j == 0) return 1;
      if (i == 0) return 0;

      if (dp[i][j] != -1) return dp[i][j];

      if (s.charAt(i - 1) == t.charAt(j - 1)) return dp[i][j] = f(i - 1, j - 1, s, t, dp) +
         f(i - 1, j, s, t, dp);
      return dp[i][j] = f(i - 1, j, s, t, dp);
   }
   public int numDistinct(String s, String t) {
      int n = s.length();
      int m = t.length();
      int[][] dp = new int[n + 1][m + 1];
      for (int row[]: dp) Arrays.fill(row, -1);
      return f(n, m, s, t, dp);

   }
}

***************************************Tabulation approach****************************************
//Tabulation
class Solution {
   public int numDistinct(String s, String t) {
      int n = s.length();
      int m = t.length();
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) dp[i][0] = 1;
      //for(int j=0;j<=m;j++) dp[0][j]=0;
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= m; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1))
               dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            else dp[i][j] = dp[i - 1][j];
         }
      }
      return dp[n][m];

   }
}  


***************************************Space optimization approach****************************************
//Space optimization

class Solution {
   public int numDistinct(String s, String t) {
      int n = s.length();
      int m = t.length();
      int[] prev = new int[m + 1];
      prev[0] = 1;

      for (int i = 1; i <= n; i++) {

         for (int j = m; j > 0; j--) {
            if (s.charAt(i - 1) == t.charAt(j - 1))
               prev[j] = prev[j - 1] + prev[j];
            else prev[j] = prev[j];
         }

      }
      return prev[m];

   }
}