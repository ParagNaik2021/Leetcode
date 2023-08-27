class Solution {
    public int removeDuplicates(int[] nums) {
         int i=0;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[i]!=nums[j])
            {
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}

#####################################Coding ninja solution##############################################
Note- Logic is same but here ArrayList is used and dont use add Function of Al use Set function of AL

import java.util.ArrayList;

public class Solution {
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
        // Write your code here.
        int i=0;
        for(int j=1;j<n;j++)
        {
            if(!arr.get(j).equals(arr.get(i))){
                arr.set(i+1,arr.get(j));
                i++;
            }
            
        }
        return i+1;
    }
}