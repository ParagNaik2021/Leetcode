    Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // code here
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next_current = current.next;
            current.next = prev;
            prev = current;
            current = next_current;
        }
        return prev;
    }

