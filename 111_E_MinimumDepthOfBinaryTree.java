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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null) {
            return minDepth(root.right) + 1;
        } 
        
        if(root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        
    }
    
    //BFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        
        while(!q.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            
            while(!q.isEmpty()) {
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null) {
                    return level;
                }
                if(cur.left != null) {
                    tmp.offer(cur.left);
                }
                if(cur.right != null) {
                    tmp.offer(cur.right);
                }
            }
            
            q = tmp;
            level++;
        }
        return level;
    }
}
