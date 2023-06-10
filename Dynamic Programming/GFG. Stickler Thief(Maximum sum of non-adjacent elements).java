**********************************Recurssion- Frog Jump*****************************************

class Solution {
   public int f(int index, int[] arr) {
      if (index == 0) return arr[index];
      if (index < 0) return 0;

      int picked = arr[index] + f(index - 2, arr);
      int notpicked = 0 + f(index - 1, arr);

      return Math.max(picked, notpicked);
   }
   //Function to find the maximum money the thief can get.
   public int FindMaxSum(int arr[], int n) {
      // Your code here

      return f(n - 1, arr);
   }
}

****************************Memoization approach***************************************************


class Solution
{
    public int f(int index,int[] arr,int[] dp)
    {
        if(index==0) return arr[index];
        if(index<0) return 0;
        
        if(dp[index]!=-1)
            return dp[index];
            
        int picked=arr[index]+f(index-2,arr,dp);
        int notpicked=0+f(index-1,arr,dp);
        
        return dp[index]=Math.max(picked,notpicked);
        
        
        
    }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return f(n-1,arr,dp);
    }
    
}


***************************************Tabulation approach****************************************

class Solution
{
    public int f(int index,int[] arr,int[] dp)
    {
        dp[0]=arr[0];
        int neg=0;
        for(int i=1;i<=index;i++)
        {
            int picked=arr[i];
            if(i>1)
            {
                picked+=dp[i-2];
            }
            int notpicked=0+dp[i-1];
            dp[i]=Math.max(picked,notpicked);
        }
        return dp[index];
        
    }
   
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] dp=new int[n];
        return f(n-1,arr,dp);
    }
}


***************************************space optimazation approach****************************************

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int prev=arr[0];
        int prev2=0;
        for(int i=1;i<n;i++)
        {
            int pick=arr[i];
            if(i>1) pick+=prev2;
            
            int notpick=0+prev;
            int curri=Math.max(pick,notpick);
            prev2=prev;
            prev=curri;
        }
        
        return prev;
        
    }
}