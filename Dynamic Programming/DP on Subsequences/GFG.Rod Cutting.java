**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
class Solution{
    public static int f(int ind,int N,int[] price)
    {
        if(ind==0) return N*price[0];
        
        
        int notTake=0+f(ind-1,N,price);
        int take=(int) Math.pow(-10,9);
        int rodlength=ind+1;
        if(rodlength<=N) take=price[ind]+f(ind,N-rodlength,price);
        
        return Math.max(take,notTake);
        
    }
    public int cutRod(int price[], int n) {
        return f(n-1,n,price);
    }
}

****************************Memoization approach***************************************************
//Memoization
class Solution{
    public static int f(int ind,int N,int[] price,int[][] dp)
    {
        if(ind==0) return N*price[0];
        
        if(dp[ind][N]!=-1) return dp[ind][N];
        
        int notTake=0+f(ind-1,N,price,dp);
        int take=(int) Math.pow(-10,9);
        int rodlength=ind+1;
        if(rodlength<=N) take=price[ind]+f(ind,N-rodlength,price,dp);
        
        return dp[ind][N]=Math.max(take,notTake);
        
    }
    public int cutRod(int price[], int n) {
        //code here
        //int ind=price.length;
        int[][] dp=new int[n][n+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n-1,n,price,dp);
    }
}

***************************************Tabulation approach****************************************
//Tabulation
class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp=new int[n][n+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        for(int i=0;i<=n;i++) dp[0][i]=i*price[0];
        
        for(int ind=1;ind<n;ind++)
        {
            for(int N=0;N<=n;N++)
            {
                int notTake=0+dp[ind-1][N];
                int take=(int) Math.pow(-10,9);
                int rodlength=ind+1;
                if(rodlength<=N) take=price[ind]+dp[ind][N-rodlength];
            
                dp[ind][N]=Math.max(take,notTake);
            }
        }
        
        return dp[n-1][n];
    }
}
   


***************************************Space optimization approach--->2 D Array****************************************
//Space optimization
//space optimization
class Solution{
    public int cutRod(int price[], int n) {
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int i=0;i<=n;i++) prev[i]=i*price[0];
        
        for(int ind=1;ind<n;ind++)
        {
            for(int N=0;N<=n;N++)
            {
                int notTake=0+prev[N];
                int take=(int) Math.pow(-10,9);
                int rodlength=ind+1;
                if(rodlength<=N) take=price[ind]+curr[N-rodlength];
            
              curr[N]=Math.max(take,notTake);
            }
            prev=curr;
        }
        
        return prev[n];
    }
}



***************************************Space optimization approach--->1D Array****************************************


class Solution{
    public int cutRod(int price[], int n) {
        int[] prev=new int[n+1];
        for(int i=0;i<=n;i++) prev[i]=i*price[0];
        
        for(int ind=1;ind<n;ind++)
        {
            for(int N=0;N<=n;N++)
            {
                int notTake=0+prev[N];
                int take=(int) Math.pow(-10,9);
                int rodlength=ind+1;
                if(rodlength<=N) take=price[ind]+prev[N-rodlength];
            
              prev[N]=Math.max(take,notTake);
            }
          
        }
        
        return prev[n];
    }
}