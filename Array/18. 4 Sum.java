

**************************************Optimized Solution**************************************************************
class Solution {
   public List < List < Integer >> fourSum(int[] nums, int target) {
      List < List < Integer >> result = new ArrayList < > ();
      int n = nums.length;
      Arrays.sort(nums);
      for (int i = 0; i < n; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) continue;

         for (int j = i + 1; j < n; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            int k = j + 1;
            int l = n - 1;

            while (k < l) {
               long sum = Long.valueOf(nums[i]);
               sum += Long.valueOf(nums[j]);
               sum += Long.valueOf(nums[k]);
               sum += Long.valueOf(nums[l]);

               if (sum == target) {
                  List temp = new ArrayList < > ();
                  temp.add(nums[i]);
                  temp.add(nums[j]);
                  temp.add(nums[k]);
                  temp.add(nums[l]);
                  result.add(temp);
                  k++;
                  l--;

                  while (k < l && nums[k] == nums[k - 1]) k++;

                  while (k < l && nums[l] == nums[l + 1]) l--;
               } else if (sum < target) k++;

               else l--;
            }
         }
      }

      return result;
   }
}