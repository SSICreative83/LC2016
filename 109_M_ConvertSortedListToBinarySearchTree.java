/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(dummy.next != null) {
            len ++;
            dummy = dummy.next;
        }
        
        return toBST(head, len);
    }
    
    public TreeNode toBST(ListNode head, int len) {
        if(head == null || len <= 0)    return null;
        if(head.next == null || len == 1)   return new TreeNode(head.val);
        
        ListNode mid = head;
        for(int i = 0; i < len / 2; i++){
            mid = mid.next; //mid is the right side middle
        }
        
        TreeNode root = new TreeNode(mid.val);
        if(len % 2 != 0){
            root.left = toBST(head, len / 2);
            root.right = toBST(mid.next, len / 2);
        }else{
            root.left = toBST(head, len / 2);
            root.right = toBST(mid.next, len / 2 - 1);            
        }
        
        return root;
    }
    
}
