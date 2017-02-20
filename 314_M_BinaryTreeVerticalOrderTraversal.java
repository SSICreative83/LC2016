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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        int minLevel=0;
        int maxLevel=0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> treeQue = new LinkedList<>();
        Queue<Integer> levelQue = new LinkedList<>();
        
        treeQue.offer(root);
        levelQue.offer(0);
        
        while(!treeQue.isEmpty()) {
            TreeNode cur = treeQue.poll();
            int level = levelQue.poll();
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
            
            if(map.containsKey(level)) {
                List<Integer> curLevel = map.get(level);
                curLevel.add(cur.val);
            } else {
                List<Integer> newLevel = new ArrayList<>();
                newLevel.add(cur.val);
                map.put(level, newLevel);
            }
            
            if(cur.left != null) {
                treeQue.offer(cur.left);
                levelQue.offer(level - 1);
                
            }
            if(cur.right != null) {
                treeQue.offer(cur.right);
                levelQue.offer(level + 1);
            }
        }
        
        for(int i = minLevel; i <= maxLevel; i++) {
            if(map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}
