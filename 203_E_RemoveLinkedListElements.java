/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        
        while(p != null && p.next != null) {
            if(p.next.val == val) {
                p = removeNext(p);
            } else {
                p = p.next;
            }
        }
        
        return dummy.next;
    }
    
    public ListNode removeNext(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        head.next = head.next.next;
        return head;
    }
}
