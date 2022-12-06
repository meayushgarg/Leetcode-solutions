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
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = head, prev = dummy;

        while(curr!=null && curr.next!=null){
            ListNode c1 = curr, c2 = curr.next;
            ListNode f1 = c2.next;

            c1.next = c2.next = null;

            prev.next = c2;
            c2.next = c1;

            prev = c1;
            curr = f1;
        }

        prev.next = curr;
        return dummy.next;
    }
}
