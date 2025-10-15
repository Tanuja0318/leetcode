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
    public ListNode partition(ListNode head, int x) {
        ListNode p=new ListNode(0);
        ListNode q=new ListNode(0);
        ListNode np=p;
        ListNode nq=q;
        while(head!=null){
            if(head.val<x){
                np.next=head;
                np=np.next;
            }
            else{
                nq.next=head;
                nq=nq.next;
            }
            head=head.next;
        }
        np.next=q.next;
        nq.next=null;
        return p.next;
    }
}