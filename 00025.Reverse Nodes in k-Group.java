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

    ListNode th,tt;

    public void addFirst(ListNode node){
        if(th == null){
            th = tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null){
            return head;
        }

        int len = getLen(head);
        ListNode curr = head, oh = null, ot = null;
        th = tt = null;

        while(len >= k){
            int temp = k;
            
            while(temp-->0){
                ListNode next = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = next;
            }

            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }

            th = tt = null;
            len-=k;
        }

        ot.next = curr;
        return oh;
    }

    public int getLen(ListNode curr){
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }

        return count;
    }
}
