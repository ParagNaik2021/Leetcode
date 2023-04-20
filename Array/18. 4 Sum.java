*************************************Brute Force********************************************************************
287 / 292 testcases passed

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
          List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int h = k + 1; h < nums.length; h++) {
                        if (nums[i] + nums[j] + nums[k] + nums[h] == target) {
                            List temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[h]);
                          Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        LinkedHashSet<List<Integer>> hashSet = new LinkedHashSet<>(result);
        List<List<Integer>> ans = new ArrayList<>(hashSet);
        return ans;
    }
}


**************************************Better Solution****************************************************************

290 / 292 testcases passed

class Solution {
   public List < List < Integer >> fourSum(int[] nums, int target) {
      List < List < Integer >> result = new ArrayList < > ();

      int n = nums.length;
      if (n < 4) {
         return result;
      }

      int sum1 = nums[0] + nums[1] + nums[2] + nums[3];
      if (n == 4 && sum1 == target) {
         List temp = new ArrayList < > ();
         for (int i = 0; i < n; i++) {
            temp.add(nums[i]);
         }
         result.add(temp);
         return result;
      }

      if (nums.length == 4 && sum1 == target) {
         System.out.println(sum1);
         return result;
      }

      for (int i = 0; i < nums.length; i++) {
         for (int j = i + 1; j < nums.length; j++) {
            HashSet hs = new HashSet < > ();
            for (int k = j + 1; k < nums.length; k++) {
               int sum = nums[i] + nums[j];
               sum += nums[k];
               int fourth = target - (sum);
               if (hs.contains(fourth)) {
                  List temp = new ArrayList < > ();
                  temp.add(nums[i]);
                  temp.add(nums[j]);
                  temp.add(nums[k]);
                  temp.add(fourth);
                  Collections.sort(temp);
                  result.add(temp);
               }
               hs.add(nums[k]);
            }
         }
      }

      LinkedHashSet < List < Integer >> hashSet = new LinkedHashSet < > (result);
      List < List < Integer >> ans = new ArrayList < > (hashSet);
      return ans;

   }
}




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