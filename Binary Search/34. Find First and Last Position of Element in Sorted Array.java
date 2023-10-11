**********************************Binary Search- Find First and Last Position of Element in Sorted Array *****************************************

class Solution {
   public static int lowerBoundElement(int[] arr, int target) {
      int n = arr.length;
      int low = 0;
      int high = n - 1;
      int ans = n;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (arr[mid] >= x) {
            ans = mid;
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }
      return ans;

   }

   public static int uperBoundElement(int[] nums, int target) {
      int low = 0;
      int n = arr.length;
      int high = n - 1;
      int ans = n;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (arr[mid] > x) {
            ans = mid;
            high = mid - 1;
         } else {
            low = mid + 1;
         }
      }
      return ans;
   }

   public int[] searchRange(int[] nums, int target) {

      int lowerBound = lowerBoundElement(arr, n, x);
      int upperBound = uperBoundElement(arr, n, x);
      return new int[] {
         lowerBound,
         upperBound
      };
   }
}