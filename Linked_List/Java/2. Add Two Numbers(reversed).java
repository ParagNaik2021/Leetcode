public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int addition = 0;
            if (l1 != null) {
                addition += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                addition += l2.val;
                l2 = l2.next;
            }
            addition += carry;
            carry = addition / 10;
            if (carry > 0) {
                addition = addition % 10;
            }

            ListNode node = new ListNode(addition);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }



