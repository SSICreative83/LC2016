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
    //Solution1: fast and slow are initially head
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        if(head == null)    return null;
        
        while(n > 0){
            fast = fast.next;
            n--;
        }
        
        //if remove head
        if(fast == null){
            return slow.next;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        //remove slow.next
        slow.next = slow.next.next;
        
        return head;
    }
    
    //Solution2: fast and slow are initially pointing to head
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        
        while(fast.next != null && n > 0) {
            fast = fast.next;
            n--;
        }
        
        if(fast.next == null) {//delete head
            return head.next;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}
