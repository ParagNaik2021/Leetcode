**********************************Recurssion- Longest Common Subsequence but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE

class Solution {
    public static int f(int ind1,String s1,int ind2, String s2)
    {
        //in case one of the String is exhausted
        if(ind1<0 || ind2<0) return 0;

        //if the char comparing gives true
        if(s1.charAt(ind1)==s2.charAt(ind2)) return 1+f(ind1-1,s1 ,ind2-1,s2);
        else return 0+Math.max(f(ind1-1,s1,ind2,s2),f(ind1,s1,ind2-1,s2));

    }

    public int longestCommonSubsequence(String text1, String text2) {
     int ind1=text1.length();
     int ind2=text2.length();

     return f(ind1-1,text1,ind2-1,text2);

    }
}


****************************Memoization approach***************************************************
//Memoization
//Memoization
class Solution {
   public static int f(int ind1, String s1, int ind2, String s2, int[][] dp) {
      //in case one of the String is exhausted
      if (ind1 < 0 || ind2 < 0) return 0;

      if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

      //if the char comparing gives true
      if (s1.charAt(ind1) == s2.charAt(ind2)) {
         dp[ind1][ind2] = 1 + f(ind1 - 1, s1, ind2 - 1, s2, dp);
      } else {
         dp[ind1][ind2] = 0 + Math.max(f(ind1 - 1, s1, ind2, s2, dp), f(ind1, s1, ind2 - 1, s2, dp));
      }
      return dp[ind1][ind2];
   }

   public int longestCommonSubsequence(String text1, String text2) {
      int ind1 = text1.length();
      int ind2 = text2.length();
      int[][] dp = new int[ind1][ind2];
      for (int row[]: dp) Arrays.fill(row, -1);

      return f(ind1 - 1, text1, ind2 - 1, text2, dp);

   }
}

***************************************Tabulation approach****************************************
//Tabulation
//Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     int n=text1.length();
     int m=text2.length();
     int[][] dp=new int[n+1][m+1];
     for(int i=0;i<=n;i++) dp[i][0]=0;

     for(int i=0;i<=m;i++) dp[0][i]=0;

     for(int ind1=1;ind1<=n;ind1++) {
         for(int ind2=1;ind2<=m;ind2++)
         {
             if(text1.charAt(ind1-1)==text2.charAt(ind2-1)) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
             else
             dp[ind1][ind2]=0+ Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
         }
     }
  

     return dp[n][m];

    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
//space optimization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     int n=text1.length();
     int m=text2.length();
     int[] prev=new int[m+1];
     int[] curr=new int[m+1];
     
  
     for(int ind1=1;ind1<=n;ind1++) {
         for(int ind2=1;ind2<=m;ind2++)
         {
             if(text1.charAt(ind1-1)==text2.charAt(ind2-1)) curr[ind2]=1+prev[ind2-1];
             else
             curr[ind2]=0+ Math.max(prev[ind2],curr[ind2-1]);
         }
         prev=(int[]) curr.clone();
     }
  

     return prev[m];

    }
}