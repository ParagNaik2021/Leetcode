**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE
class Solution {
    static boolean isAllStars(String S1, int i) {
    for (int j = 0; j <= i; j++) {
      if (S1.charAt(j) != '*')
        return false;
    }
    return true;
  }
    public boolean f(int i,int j,String pattern,String text)
    {
        //base case
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0)
        {
           return isAllStars(pattern,i) ? true : false;
        }
        if(pattern.charAt(i)==text.charAt(j) || pattern.charAt(i) == '?')
            return f(i-1,j-1,pattern,text);
        if(pattern.charAt(i) == '*')
        {
            return f(i-1,j,pattern,text) || f(i,j-1,pattern,text);
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        //p-->pattern , s--->String
        int n=p.length();
        int m=s.length();

        return f(n-1,m-1,p,s);
    }
}

****************************Memoization approach***************************************************
//Memoization
//Memization
class Solution {
    static boolean isAllStars(String S1, int i) {
    for (int j = 0; j <= i; j++) {
      if (S1.charAt(j) != '*')
        return false;
    }
    return true;
  }
    public int f(int i,int j,String pattern,String text,int[][] dp)
    {
        //base case
        if(i<0 && j<0) return 1;
        if(i<0 && j>=0) return 0;
        if(j<0 && i>=0)
        {
           return isAllStars(pattern,i) ? 1 : 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(pattern.charAt(i)==text.charAt(j) || pattern.charAt(i) == '?')
            return dp[i][j]=f(i-1,j-1,pattern,text,dp);
        if(pattern.charAt(i) == '*')
        {
            return (f(i-1,j,pattern,text,dp)==1 || f(i,j-1,pattern,text,dp)==1) ? 1:0;
        }
        return 0;
    }
    public boolean isMatch(String s, String p) {
        //p-->pattern , s--->String
        int n=p.length();
        int m=s.length();
        int[][] dp=new int[n+1][m+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return (f(n-1,m-1,p,s,dp)==1) ? true: false;
    }
}

***************************************Tabulation approach****************************************
//Tabulation
//Memization
class Solution {
    static boolean isAllStars(String S1, int i) {
            for (int j = 1; j <= i; j++) {
            if (S1.charAt(j-1) != '*')
                return false;
            }
            return true;
        }
            
    public boolean isMatch(String s, String p) {
        //p-->pattern , s--->String
        int n=p.length();
        int m=s.length();
        boolean [][] dp=new boolean [n+1][m+1];
        dp[0][0]=true;

        for(int j=1;j<=m;j++) dp[0][j]=false;

        for(int i=1;i<=n;i++) dp[i][0]=isAllStars(p,i);

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1) == '?')
                    dp[i][j]=dp[i-1][j-1];
             else{
                 if(p.charAt(i-1) == '*')
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                 else dp[i][j]=false;
                 }
            }
        }

        return dp[n][m];    
    }
}
   


***************************************Space optimization approach****************************************
//Space optimization
//Memization
class Solution {
    static boolean isAllStars(String S1, int i) {
            for (int j = 1; j <= i; j++) {
            if (S1.charAt(j-1) != '*')
                return false;
            }
            return true;
        }
            
    public boolean isMatch(String s, String p) {
        //p-->pattern , s--->String
        int n=p.length();
        int m=s.length();
        boolean [] prev=new boolean [m+1];
        boolean [] curr=new boolean [m+1];
        prev[0]=true;

      //  for(int j=1;j<=m;j++) dp[0][j]=false;

        //for(int i=1;i<=n;i++) dp[i][0]=isAllStars(p,i);

        for(int i=1;i<=n;i++)
        {
            curr[0]=isAllStars(p,i);
            for(int j=1;j<=m;j++)
            {
                if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1) == '?')
                    curr[j]=prev[j-1];
             else{
                 if(p.charAt(i-1) == '*')
                    curr[j]=prev[j] || curr[j-1];
                 else curr[j]=false;
                 }
            }
            prev=(boolean[]) curr.clone();
        }
        return prev[m];
     
    }
}