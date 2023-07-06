**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
    public int f(int i,int j,String s1,String s2)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return f(i-1,j-1,s1,s2);

//case where it not matches so we insert, delete , replace
        return 1+Math.min(
            f(i-1,j,s1,s2),
            Math.min(f(i,j-1,s1,s2),f(i-1,j-1,s1,s2))
        );
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        return f(n-1,m-1,word1,word2);
    }
}


****************************Memoization approach***************************************************
//Memoization
class Solution {
    public int f(int i,int j,String s1,String s2,int[][] dp)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=f(i-1,j-1,s1,s2,dp);

//case where it not matches so we insert, delete , replace
        return dp[i][j]=1+Math.min(
            f(i-1,j,s1,s2,dp),
            Math.min(f(i,j-1,s1,s2,dp),f(i-1,j-1,s1,s2,dp))
        );
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int row[]:dp) Arrays.fill(row,-1);

        return f(n-1,m-1,word1,word2,dp);
    }
}

***************************************Tabulation approach****************************************
//Tabulation
class Solution {

   public int minDistance(String word1, String word2) {
      int n = word1.length();
      int m = word2.length();
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) dp[i][0] = i;
      for (int i = 0; i <= m; i++) dp[0][i] = i;

      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= m; j++) {

            if (word1.charAt(i - 1) == word2.charAt(j - 1))
               dp[i][j] = dp[i - 1][j - 1];

            //case where it not matches so we insert, delete , replace
            else dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));

         }

      }
      return dp[n][m];

   }
}
   
***************************************Space optimization approach****************************************
//Space optimization
class Solution {

   public int minDistance(String word1, String word2) {
      int n = word1.length();
      int m = word2.length();
      int[] prev = new int[m + 1];

      for (int i = 0; i <= m; i++) prev[i] = i;

      for (int i = 1; i <= n; i++) {
         int[] curr = new int[m + 1];
         curr[0] = i;
         for (int j = 1; j <= m; j++) {

            if (word1.charAt(i - 1) == word2.charAt(j - 1))
               curr[j] = prev[j - 1];

            //case where it not matches so we insert, delete , replace
            else curr[j] = 1 + Math.min(prev[j], Math.min(curr[j - 1], prev[j - 1]));

         }
         prev = curr;

      }
      return prev[m];

   }
}