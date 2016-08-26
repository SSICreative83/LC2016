/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)    return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = head;
        ListNode slow = dummy;
        
        while(fast != null && fast.next != null) {
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = fast;
            
            slow = fast;
            fast = fast.next;
        }
        
        return dummy.next;
    }
}
