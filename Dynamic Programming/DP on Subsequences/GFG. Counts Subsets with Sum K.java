**********************************Recurssion- Unique Path but time limit exceed *****************************************
//Recurrssion-Coding Ninja--->TLE
class Solution{
    public static int f(int ind,int target,int[] arr)
    {
            if(ind == 0){
                if(target==0 && arr[0]==0)
                    return 2;
                if(target==0 || target == arr[0])
                    return 1;
                return 0;
            }
        
        int notTaken = f(ind-1,target,arr);
        
        int taken = 0;
        if(arr[ind]<=target)
            taken = f(ind-1,target-arr[ind],arr);
            
        return (notTaken + taken)%(int)(Math.pow(10,9)+7);
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	     return f(n-1,sum,arr);
	} 
}

****************************Memoization approach***************************************************
//Memoization
class Solution{
    public static int f(int ind,int target,int[] arr,int[][] dp)
    {
            if(ind == 0){
                if(target==0 && arr[0]==0)
                    return 2;
                if(target==0 || target == arr[0])
                    return 1;
                return 0;
            }
        
        if(dp[ind][target]!=-1)
            return dp[ind][target];
            
        int notTaken = f(ind-1,target,arr,dp);
        
        int taken = 0;
        if(arr[ind]<=target)
            taken = f(ind-1,target-arr[ind],arr,dp);
            
        return dp[ind][target]= (notTaken + taken)%(int)(Math.pow(10,9)+7);
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    // int n = num.length;
    int dp[][]= new int[n][sum+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
    
    return f(n-1,sum,arr,dp);
	} 
}

***************************************Tabulation approach****************************************
//Tabulation

//tabulatio
class Solution{
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    // int n = num.length;
    int dp[][]= new int[n][sum+1];
    
    int mod=(int) Math.pow(10,9)+7;
    for(int i=0;i<n;i++)
    {
        dp[i][0]=1;
    }
    if(arr[0]==0)
        dp[0][0]=2;
    else{
        dp[0][0]=1;
        if(sum>=arr[0])
          dp[0][arr[0]]=1;
        }
    
    for(int index=1;index<n;index++)
    {
        for(int target=0;target<=sum;target++)
        {
            int notTaken=dp[index-1][target];
            int taken=0;
            if(arr[index]<=target)
                taken=dp[index-1][target-arr[index]];
            
            dp[index][target]=(notTaken+taken)%mod;
        }
    }
    
    return dp[n-1][sum];
	} 
}
   


***************************************Space optimization approach****************************************
//Space optimization
class Solution{
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    // int n = num.length;
    int prev[]= new int[sum+1];
    prev[0]=1;
     if(arr[0]==0)
        prev[0]=2;
    else{
        prev[0]=1;
        if(sum>=arr[0])
          prev[arr[0]]=1;
        }
    
    int mod=(int) Math.pow(10,9)+7;
    
    for(int index=1;index<n;index++)
    {
        int[] curr=new int[sum+1];
        curr[0]=1;
        for(int target=0;target<=sum;target++)
        {
            int notTaken=prev[target];
            int taken=0;
            if(arr[index]<=target)
                taken=prev[target-arr[index]];
            
            curr[target]=(notTaken+taken)%mod;
        }
        prev=curr;
    }
    
    return prev[sum];
	} 
}