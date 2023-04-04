************Optimal Solution********************************************************

class Solution {
   public int maxSubArray(int[] nums) {
    //Optimal-Kadane Algorithm--->TC=O(N) & SC=O(1)
      int max = Integer.MIN_VALUE;
      int sum = 0;

      for (int i = 0; i < nums.length; i++) {
         sum = sum + nums[i];
         if (sum > max) {
            max = sum;
         }
         if (sum <= 0) {
            sum = 0;
         }

      }

      return max;

   }
}



***************************** Varition in Question***********************************
If they ask you to find the subarray with max NoSuchMethodException


package org.example.Array;

import java.util.ArrayList;

public class Maximumsubarray {

   public static int maxSubarray(int[] nums, ArrayList < Integer > subarray) {
      int maxi = Integer.MIN_VALUE;
      int sum = 0;
      int ansStart = 0;

      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (sum > maxi) {
            subarray.clear();
            maxi = sum;
            subarray.add(ansStart);
            subarray.add(i);
         }
         if (sum <= 0) {
            sum = 0;
            ansStart = i + 1;
         }

      }
      return maxi;
   }

   public static void main(String[] args) {
         int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
      ArrayList < Integer > subarray = new ArrayList < > ();
      int maxvalue = maxSubarray(arr, subarray);

      for (int i = subarray.get(0); i <= subarray.get(1); i++) {
         System.out.print(arr[i] + " ");
      }
   }
}