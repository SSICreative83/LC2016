/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int flag = 0;
        while(l1 != null || l2 != null || flag != 0) {
            int curVal;
            if(l1 != null && l2 == null) {
                curVal = l1.val;
                l1 = l1.next;
            } else if(l1 == null && l2 != null) {
                curVal = l2.val;
                l2 = l2.next;
            } else if(l1 != null && l2 != null){
                curVal = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else {    //only flag
                curVal = 0;
            }
            
            int newVal = (curVal + flag) % 10;
            flag = (curVal + flag) >= 10 ? 1 : 0;
            
            ListNode nnode = new ListNode(newVal);
            l3.next = nnode;
            l3 = l3.next;
        }
        
        return head.next;
    }
}
