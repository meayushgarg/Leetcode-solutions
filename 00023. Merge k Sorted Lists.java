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

// 1st approach

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return (list1!=null? list1: list2);
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = list1, c2 = list2;

        while(c1!=null && c2!=null){
            if(c1.val <= c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = (c1!=null? c1: c2);
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        ListNode ans = null;
        for(int i=0; i<lists.length; i++){
            ans = mergeTwoLists(ans,lists[i]);
        }

        return ans;
    }
}

// 2nd approach

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, tail = dummy;

        for(int i=0; i<lists.length; i++){
            ListNode curr = lists[i];
            if(curr!=null){
                tail.next = curr;
                tail = getTail(curr);
            }
        }

        head = dummy.next;
        head = mergeSort(head);
        return head;
    }

    public ListNode getTail(ListNode head){
        ListNode curr = head;

        while(curr.next!=null){
            curr = curr.next;
        }

        return curr;
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nhead);

        return mergeTwoLists(left,right);
    }

    public ListNode midNode(ListNode head){
        ListNode slow = head, fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return (list1!=null? list1: list2);
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = list1, c2 = list2;

        while(c1!=null && c2!=null){
            if(c1.val <= c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = (c1!=null? c1: c2);
        return dummy.next;
    }
}

// 3rd approach

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        return mergeKLists_(lists,0,lists.length-1);
    }

    public ListNode mergeKLists_(ListNode[]lists, int low, int hi){
        if(low == hi){
            return lists[low];
        }

        int mid = (low + hi) / 2;
        ListNode left = mergeKLists_(lists,low,mid);
        ListNode right = mergeKLists_(lists,mid+1,hi);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return (list1!=null? list1: list2);
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, c1 = list1, c2 = list2;

        while(c1!=null && c2!=null){
            if(c1.val <= c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = (c1!=null? c1: c2);
        return dummy.next;
    }
}
