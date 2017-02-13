/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        
        int len = 1;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            len++;
        }
        if(fast != null) {
            slow = slow.next;
        } 
        
        ListNode rareHead = reverse(slow);
        ListNode newHead = head;
        
        while(rareHead != null) {
            if(newHead.val != rareHead.val) {
                return false;
            }
            newHead = newHead.next;
            rareHead = rareHead.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
