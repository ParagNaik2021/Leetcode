**********************************Print all LCS sequences *****************************************

class Solution
{
   List<String> al = new ArrayList<>();
    List<String> res = new ArrayList<>();
    HashSet<String> hs = new HashSet<>();
    
    public void helper(String s,String t,int n,int m,int i,int j,int len)    {
        if(len==0) 
        {
            String ns=String.join("",al);
            if(!hs.contains(ns)) 
            {
                hs.add(ns);
                res.add(ns);
            }
             
        }
        
    //    if(i>=s.length()|| j>=t.length()) return  ;
        
        for(int row=i;row<n;row++)
        {
            for(int col=j;col<m;col++)
            {
                if(s.charAt(row)==t.charAt(col))
                {
                    al.add(Character.toString(s.charAt(row)));
                    helper(s,t,n,m,row+1,col+1,len-1);
                    al.remove(al.size()-1);
                }
            }
        }
        
    }
    public List<String> all_longest_common_subsequences(String s1, String s2)
    {
        // Code here
        int n=s1.length();
        int m=s2.length();
        
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++) dp[i][0]=0;
        
        for(int i=0;i<=m;i++) dp[0][i]=0;
        
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        int len=dp[n][m];
        
        List<String> ans=new ArrayList();
        String temp="";
        
     
        helper(s1,s2,n,m,0,0,len);
        Collections.sort(res);
        return res;
    }
}