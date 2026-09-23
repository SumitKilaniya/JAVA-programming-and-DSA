/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode t = head;
        if(k == 0 || head == null) return head;
        int len = 1;
        while( t.next != null){
            len++;
            t = t.next;
        }
        t.next = head;
        t = head;

        k = k%len;
        int steps = len - k - 1;
        while( steps > 0 ){
            steps--;
            t = t.next;
        }
        ListNode res = t.next;
        t.next = null;

        return res;
    }
}