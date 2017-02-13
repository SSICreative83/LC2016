/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)  return null;
        
        int lenA = 1, lenB = 1;
        ListNode a = headA, b = headB;
        while(a.next != null) {
            lenA++;
            a = a.next;
        }
        while(b.next != null) {
            lenB++;
            b = b.next;
        }
        
        ListNode fast, slow;
        if(lenA >= lenB) {
            fast = headA;
            slow = headB;
        } else {
            fast = headB;
            slow = headA;
        }
        
        int dif = Math.abs(lenA - lenB);
        
        while(dif > 0) {
            fast = fast.next;
            dif--;
        }
        
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}
