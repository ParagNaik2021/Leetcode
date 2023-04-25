**********Optimal Solution*********************************
class Solution {

   static ListNode Reverse(ListNode curr) {
      ListNode prev = null;
      ListNode nex = null;

      while (curr != null) {
         nex = curr.next;
         curr.next = prev;
         prev = curr;
         curr = nex;
      }
      return prev;
   }
   public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) return true;

      ListNode slow = head;
      ListNode fast = head;

      while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      slow.next = Reverse(slow.next);
      slow = slow.next;
      ListNode dummy = head;

      while (slow != null) {
         if (dummy.val != slow.val) return false;

         dummy = dummy.next;
         slow = slow.next;
      }

      return true;
   }
}



**********************************Brute Force*****************************************

class Solution {
    public boolean isPalindrome(ListNode head) {
    /*Striver Brute force approach
         Time Complexity: O(N)
        Reason: Iterating through the list to store elements in the array.
        Space Complexity: O(N)
        Reason: Using an array to store list elements for further computations.
       */ 
        ArrayList arr=new ArrayList<>();
        ListNode itr=head;

        while(itr!=null)
        {
            arr.add(itr.val);
            itr=itr.next;
        }

         for(int i=0;i<arr.size()/2;i++) 
        if(arr.get(i) != arr.get(arr.size()-i-1)) //Compare the first half in arr with the second arr
             return false;
        
        return true;

    }
}