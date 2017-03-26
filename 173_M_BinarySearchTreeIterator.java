/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// stack solution, next() is not always O(1), but average should be O(1)
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if(cur.right != null) {
            TreeNode p = cur.right;
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return cur.val;
    }
    
    private void pushLeft(TreeNode root) {
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }
}

// below solution doesn't meet O(h) memory requirement
public class BSTIterator {

    Queue<TreeNode> treeQ = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !treeQ.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return treeQ.poll().val;    //poll() will return first value, and delete it from the queue
    }
    
    private void inorderTraversal(TreeNode root) {
    if (root != null) {
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        treeQ.add(root);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
    }
}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
