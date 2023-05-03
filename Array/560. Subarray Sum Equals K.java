*****************************Optimal Solution**********************************
class Solution {
   public int subarraySum(int[] nums, int k) {
      //Optimal Solution TC-O(N) but not strivers
      int n = nums.length;
      Map < Integer, Integer > map = new HashMap < Integer, Integer > ();
      int presum = 0, count = 0;
      map.put(0, 1);
      for (int i = 0; i < n; i++) {
         presum += nums[i];
         int remove = presum - k;
         if (map.containsKey(remove)) {
            count += map.get(remove);
         }
         map.put(presum, map.getOrDefault(presum, 0) + 1);
      }

      return count;
   }
}

TC-->O(N), SC-->O(N)