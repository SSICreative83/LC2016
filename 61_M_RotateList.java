/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        
        int len = 1;
        ListNode test = head;
        while(test.next != null) {
            len++;
            test = test.next;
        }
        k = k % len;
        if(k == 0)  return head;

        ListNode fast = head;
        ListNode slow = head;
        while(k > 0 && fast.next != null) {
            fast = fast.next;
            k--;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        
        return newHead;
        
    }
}
