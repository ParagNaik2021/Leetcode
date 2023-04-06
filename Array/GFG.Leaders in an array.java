class Solution {
   //Function to find the leaders in the array.
   static ArrayList < Integer > leaders(int arr[], int n) {
      // Your code here
      ArrayList < Integer > ans = new ArrayList < > ();
      int maxi = Integer.MIN_VALUE;
      for (int i = n - 1; i >= 0; i--) {
         if (arr[i] >= maxi) //>= if the same number is repeated we need to add it in ans array
         {
            ans.add(Integer.valueOf(arr[i]));

         }
         //Keep track of right maximum
         maxi = Math.max(maxi, arr[i]);
      }
      Collections.reverse(ans);

      return ans;
   }
}


Comment-
Time Complexity: O(N) { Since the array is traversed single time back to front, it will consume O(N) of time where N = size of the array }.
Space Complexity: O(N) { There is no extra space being used in this approach. But, a O(N) of space for ans array will be used in the worst case }.