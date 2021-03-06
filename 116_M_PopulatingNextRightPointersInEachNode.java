/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    //self, pass only root node
   public void connect(TreeLinkNode root) {
        if(root == null)    return;
        helper(root);
    }
    
    public void helper(TreeLinkNode root) {
        if(root == null)    return;
        if(root.left == null || root.right == null) {
            return;
        }
        
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        
        helper(root.left);
        helper(root.right);
    }    
    
    //another solution, pass left and right, same logic as above
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        helper(root, root.left, root.right);
    }
    
    public void helper(TreeLinkNode root, TreeLinkNode left, TreeLinkNode right) {
        if(root == null || left == null || right == null)    return;
        left.next = right;
        if(root.next != null)   right.next = root.next.left;
        
        helper(left, left.left, left.right);
        helper(right, right.left, right.right);
    }
}
