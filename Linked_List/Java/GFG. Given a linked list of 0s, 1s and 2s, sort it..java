**************************Optimal Approach********************************

class Solution {
   //Function to sort a linked list of 0s, 1s and 2s.
   static Node segregate(Node head) {
      // add your code here
      //Optimized approach
      /*  Time Complexity: O(N), to traverse the linked list, where N is the number of nodes in the linked list. 
Space Complexity: O(1), as constant extra spae is needed to store the count.*/
      Node itr = head;
      int count0 = 0;
      int count1 = 0;
      int count2 = 0;
      while (itr != null) {
         if (itr.data == 0) {
            count0++;
         } else if (itr.data == 1) {
            count1++;
         } else {
            count2++;
         }

         itr = itr.next;
      }
      itr = head;
      while (itr != null) {

         if (count0 != 0) {
            itr.data = 0;
            count0--;
            itr = itr.next;
         } else if (count1 != 0) {
            itr.data = 1;
            count1--;
            itr = itr.next;

         } else if (count2 != 0) {
            itr.data = 2;
            count2--;
            itr = itr.next;
         }

      }
      return head;

   }
}