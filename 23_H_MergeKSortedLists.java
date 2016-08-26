/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //Solution1: merge one by one, time limit exceeded
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;
        if(lists.length == 1)   return lists[0];

        ListNode res = lists[0];
        for(int i = 1; i < lists.length; i++) {
            ListNode next = lists[i];
            res = merge2Lists(res, next);
        }
        return res;
    }
    
    //Solution2: divide and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;
        ListNode res = mergeHelper(lists, 0, lists.length - 1);
        return res;
    }
    
    public ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if(start == end)    return lists[start];
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        
        return merge2Lists(left, right);
    }
    
    public ListNode merge2Lists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
        
        return dummy.next;
    }
}
