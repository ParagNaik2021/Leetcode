**************************************Striver Solution****************************************
TC-O(3N) and SC-O(N) or O(1)

class Solution {

   public void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }
   public void reverse(int[] nums, int i, int j) {
      while (i < j)
         swap(nums, i++, j--);
   }

   public void nextPermutation(int[] nums) {
      int index = -1;
      int n = nums.length;

        if(nums==null || nums.length<=1)
        return ;

      //We will find the breakpoint
      for (int i = n - 2; i >= 0; i--) {
         if (nums[i] < nums[i + 1]) {
            index = i;
            break;
         }
      }

      //If the prefix is the last among the combination we will choose the first in sequence

      if (index == -1) {
             reverse(nums,index+1,nums.length-1);
            return ;
      }

      //swaping the break point with the immediate highest
      for (int i = n - 1; i > index; i--) {
         if (i>=0 && nums[i] > nums[index]) {
            swap(nums, i, index);
            break;
         }

      }

      reverse(nums, index + 1, nums.length - 1);
   }

}



############################Another Solution##################################
class Solution {
   public void nextPermutation(int[] nums) {

      if (nums == null || nums.length <= 1)
         return;

      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i + 1])
         i--;
      if (i >= 0) {
         int j = nums.length - 1;
         while (nums[j] <= nums[i]) {
            j--;
         }

         swap(nums, i, j);
      }
      reverse(nums, i + 1, nums.length - 1);

   }

   public void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }
   public void reverse(int[] nums, int i, int j) {
      while (i < j)
         swap(nums, i++, j--);
   }

}