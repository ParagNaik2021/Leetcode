*********************Optimal Solution******************************

class Solution {
   static Node deleteAllOccurOfX(Node head, int x) {
      // Write your code here
      if (head == null) return head;

      if (head.next == null && head.data == x) return null;

      Node temp = head;
      //delete elements that are front node that have "x" value
      while (temp != null && temp.data == x) temp = temp.next;

      //if temp is not null update its prev to null
      temp.prev = null;
      //make temp its head
      head = temp;

      //above code has delete the if x occurs at the start of DLL

      //remove node in between
      while (temp != null) {
         if (temp.data == x) {
            Node nex = temp.next;
            Node prev = temp.prev;
            if (nex != null) nex.prev = prev;
            if (prev != null) prev.next = nex;

            temp = nex;

         } else {
            temp = temp.next;
         }
      }
      return head;

   }
}

