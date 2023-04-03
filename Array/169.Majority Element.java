class Solution {
   public int majorityElement(int[] nums) {
      //optimal solution
      int count = 0;
      int ele = nums[0];
      int count1 = 0;
      int n = nums.length / 2;
      for (int i = 0; i < nums.length; i++) {
         if (count == 0) {
            count = 1;
            ele = nums[i];
         } else if (nums[i] == ele) {
            count++;
         } else {
            count--;
         }
      }

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == ele) {
            count++;
         }
      }
      if (count > n) {
         return ele;
      }

      return -1;

   }
}



-----------------------------------------------------------------------------------------
class Solution {
   public int majorityElement(int[] nums) {
 //Better solution---->TC-->O(NlogN)+O(N)  & SC-->O(N)

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
               
                map.put(nums[i],  map.get(nums[i])+ 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int n = nums.length / 2;
        for (Integer k : map.keySet()) {
            if (map.get(k) > n) {
               return k;
            }
        }

        return -1;

   }
}

