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


***************************************Tabulation approach****************************************

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