
//Optimal solution
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