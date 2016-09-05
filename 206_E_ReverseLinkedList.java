/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //recursive
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode nxt = head.next;
        nxt = reverseList(nxt);
        ListNode newHead = nxt;
        
        while(nxt.next != null) {
            nxt = nxt.next;
        }
        
        nxt.next = head;
        head.next = null;
        return newHead;
    }
    
    //iterative
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode nxt = head.next;
        ListNode pre = null;
        
        while(nxt != null) {
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        
        return pre;
    }
}
