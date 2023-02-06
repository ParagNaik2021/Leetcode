    //Function to reverse a linked list.
    Node reverseList(Node head) {
        // code here
        Node curr = head;
        if (curr == null || curr.next == null) {
            return curr;
        }
        Node n = reverseList(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return n;
    }


