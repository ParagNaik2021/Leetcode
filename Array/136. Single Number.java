
####################################Brute approach#########################################################
class Solution {
    public int singleNumber(int[] nums) {
        int count=0;
        int n=nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            count=0;
            int val=nums[i];
            for(int j=0;j<n;j++){
                if(val==nums[j]) count++;
            }
            if(count==1) return val;
        }
    return 0;
    }
}



####################################Optimal approach#########################################################
class Solution {
    public int singleNumber(int[] nums) {
       int XOR1=0;
       for(int i=0;i<nums.length;i++)
       {
           XOR1=XOR1^nums[i];
       } 

       return XOR1;
    }
}