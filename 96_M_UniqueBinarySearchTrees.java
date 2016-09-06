public class Solution {
    //time limit exceeded
    public int numTrees1(int n) {
        if(n <= 1)  return n;
        
        int res = 0;
        for(int i = 1; i <= n; i++) {
            int left = i - 1;
            int right = n - i;
            
            if(left == 0)   res += numTrees(right);
            else if(right == 0) res += numTrees(left);
            else res += numTrees(left) * numTrees(right);
        }
        
        return res;
    }
    
    public int numTrees(int n) {
        if(n <= 1)  return n;
        
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;   //num of BST when there is 1 node
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        
        return count[n];
    }
}
