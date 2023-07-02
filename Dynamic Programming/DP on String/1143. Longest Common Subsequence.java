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


***************************************Tabulation approach****************************************
//Tabulation

   


***************************************Space optimization approach****************************************
//Space optimization
