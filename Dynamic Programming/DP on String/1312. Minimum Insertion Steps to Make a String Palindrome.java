**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Leetcode--->TLE


****************************Memoization approach***************************************************
//Memoization


***************************************Tabulation approach****************************************
//Tabulation

   


***************************************Space optimization approach****************************************
//Space optimization
class Solution {
     public int lcs(String s1,String s2)
    {
        int n=s1.length();
        int m=s2.length();
        int[] prev=new int[m+1];

        for(int ind1=1;ind1<=n;ind1++)
        {
             int[] curr=new int[m+1];
            for(int ind2=1;ind2<=m;ind2++)
            {
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)) curr[ind2]=1+prev[ind2-1];
                else curr[ind2]=0+Math.max(prev[ind2],curr[ind2-1]);
            }
            prev=curr;
        }
        return prev[m];
    }
    public int minInsertions(String s) {
        String t=s;
        String rev_s=new StringBuilder(s).reverse().toString();
        int n= s.length();
        int lps= lcs(rev_s,t);
        return n-lps;   
    }
}