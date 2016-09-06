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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            List<Integer> tmp = new ArrayList<>();
            Queue<TreeNode> levelQueue = new LinkedList<>();
            
            while(!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                tmp.add(cur.val);
                
                if(cur.left != null)    levelQueue.add(cur.left);
                if(cur.right != null)   levelQueue.add(cur.right);
            }
            
            queue = levelQueue;
            res.add(tmp);
        }
        
        return res;
    }
}
