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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if(start1 > end1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[start1]);
        int i = 0;
        while(inorder[i] != preorder[start1]) {
            i++;
        }
        
        head.left = buildTreeHelper(preorder, start1 + 1, start1 + i - start2, inorder, start2, i - 1); //notice the index
        head.right = buildTreeHelper(preorder, start1 + i - start2 + 1, end1, inorder, i + 1, end2);
        return head;
    }
}
