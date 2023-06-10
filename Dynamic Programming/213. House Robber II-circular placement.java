*******************************Space optimization approach*****************************************


class Solution {

   public int f(int[] dp) {

      int n = dp.length;
      int prev = dp[0];
      int prev2 = 0;
      for (int i = 1; i < n; i++) {
         int pick = dp[i];
         if (i > 1) pick += prev2;

         int notpick = 0 + prev;
         int curri = Math.max(pick, notpick);
         prev2 = prev;
         prev = curri;
      }

      return prev;

   }
   public int rob(int[] nums) {
      int n = nums.length;
      int[] dp_first = new int[n];
      int[] dp_last = new int[n];
      if (n == 1) return nums[0];

      for (int i = 0; i < n; i++) {
         if (i != 0) dp_first[i] = nums[i];

         if (i != n - 1) dp_last[i] = nums[i];

      }

      int include_first = f(dp_first);
      int include_last = f(dp_last);

      return Math.max(include_first, include_last);

   }
}
