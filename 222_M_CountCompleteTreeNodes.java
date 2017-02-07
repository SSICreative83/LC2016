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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int leftH = leftHeight(root.left);
        int rightH = leftHeight(root.right);
        if(leftH != rightH) {
            return countNodes(root.left) + (1 << rightH);
        } else {
            return countNodes(root.right) + (1 << leftH);
        }
        
    }
    
    public int leftHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode p = root;
        int height = 0;
        while(p != null) {
            p = p.left;
            height++;
        }
        return height;
    }
}
