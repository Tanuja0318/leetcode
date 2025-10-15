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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode p=new ListNode(0);
        p.next=head;
        ListNode q=p;
        while(q.next!=null && q.next.next!=null){
            ListNode first=q.next;
            ListNode second=q.next.next;
            first.next=second.next;
            second.next=first;
            q.next=second;
            q=first;
        }
        return p.next;
    }
}