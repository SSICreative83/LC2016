/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        
        //reverse the right half and do a merge
        if(head == null || head.next == null)   return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy, mid = null, cur = dummy;
        
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        mid = slow.next;
        slow.next = null;
        
        mid = reverseList(mid);
        
        //do a merge
        ListNode first = head;
        ListNode second = mid;
        while(first != null && second != null){
            cur.next = first;
            first = first.next;
            cur.next.next = second;
            second = second.next;
            cur = cur.next.next;
        }
        
        if(first != null) {
            cur.next = first;
        }
        
    }
    
    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
