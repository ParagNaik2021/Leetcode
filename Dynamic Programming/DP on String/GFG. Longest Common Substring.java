**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE


****************************Memoization approach***************************************************
//Memoization


***************************************Tabulation approach****************************************
//Tabulation
class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;
        int ans=0;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(S1.charAt(i-1)==S2.charAt(j-1)) 
                {
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
        
    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
//User function Template for Java

class Solution {
   int longestCommonSubstr(String s1, String s2, int n, int m) {
      // code here

      int prev[] = new int[m + 1];

      int ans = 0;

      for (int i = 1; i <= n; i++) {
         int cur[] = new int[m + 1];
         for (int j = 1; j <= m; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
               int val = 1 + prev[j - 1];
               cur[j] = val;
               ans = Math.max(ans, val);
            } else
               cur[j] = 0;
         }
         prev = cur;
      }

      return ans;

   }
}