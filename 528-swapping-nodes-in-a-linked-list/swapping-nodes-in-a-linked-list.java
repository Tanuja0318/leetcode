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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return head;
        ListNode curr = head;
        for (int i = 1; i < k; i++) {
            if (curr.next != null)
                curr = curr.next;
            else
                return head; 
        }
        ListNode p = curr;
        ListNode q = head;
        while (curr.next != null) {
            q = q.next;
            curr = curr.next;
        }
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
        return head;
    }
}