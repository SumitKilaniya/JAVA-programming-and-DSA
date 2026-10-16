class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode t = head;
        ListNode before = null;
        int pos = 1;
        while (pos < left) {
            before = t;
            t = t.next;
            pos++;
        }
        ListNode current = t;
        ListNode prev = null;
        int times = right - left + 1;
        while (times-- > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }
        t.next = current;
        return head;
    }
}