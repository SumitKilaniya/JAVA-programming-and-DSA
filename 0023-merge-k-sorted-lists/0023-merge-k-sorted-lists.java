import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // Min heap: smallest node value stays at the top
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Put the first node of every non-empty list into the heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Dummy node simplifies building the result
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Get the smallest node
            ListNode smallest = pq.poll();

            // Add it to the result
            current.next = smallest;
            current = current.next;

            // Add the next node from the same list
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}