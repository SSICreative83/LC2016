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
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);  //key: need to pass max/min to subtrees
    }
    
    public boolean helper(TreeNode root, long max, long min) {
        if(root == null)    return true;
        if(root.val >= max || root.val <= min)  return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
