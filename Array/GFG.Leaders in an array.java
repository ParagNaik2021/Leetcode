##########################################Optimal Approach############################################################
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

##########################################Optimal Approach---Coding Ninja############################################################

import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
    int n=a.length;
    int maxi=Integer.MIN_VALUE;
    List<Integer> leader = new ArrayList<>(); 
    for(int i=n-1;i>=0;i--){
        if(maxi<a[i]){
            leader.add(a[i]);
        }
        maxi=Math.max(maxi,a[i]);
    }
    Collections.sort(leader);
    return  leader;
    }
}