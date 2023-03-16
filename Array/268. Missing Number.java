class Solution {
    public int missingNumber(int[] nums) {
      //Most optimal soln
        int XOR1=0;
        int XOR2=0;
        int N=nums.length;
        for(int i=0;i<N;i++)
         {
             XOR2=XOR2^nums[i];
             XOR1=XOR1^(i+1);
         }
        // XOR1=XOR1^N;//0 <= nums[i] <= n thats why no need of this line
         return XOR1^XOR2;

        /*
        //Optimal solution
        //    int N=nums.length;
        //    int summation=(N)*(N+1)/2;// this will create a problem as int cannot store 10^10 so XOR is better approach
        //    int sum=0;
            for(int i=0;i<N;i++)
                sum+=nums[i];
            return summation-sum;
        */
    }
}