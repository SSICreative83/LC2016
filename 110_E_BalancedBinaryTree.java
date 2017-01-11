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
    //top down recursion
    public boolean isBalanced1(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) > 1) {  //This check need to be before recursive call of isBalanced()
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    //bottom up recursion, use -1 to represent un-banlanced
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int L = maxDepth(root.left);
        if (L == -1) return -1;
        int R = maxDepth(root.right);
        if (R == -1) return -1;
        return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
    }
}
