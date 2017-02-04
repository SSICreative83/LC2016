
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int height = heightHelper(nestedList);
        int res = dfs(nestedList, height);
        return res;
    }
    
    public int heightHelper(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0)    return 0;
        
        int res = 1;
        for(int i = 0; i < nestedList.size(); i++) {
            if(!nestedList.get(i).isInteger()) {
                res = Math.max(res, heightHelper(nestedList.get(i).getList()) + 1);
            }
        }
        return res;
    }
    
    public int dfs(List<NestedInteger> nestedList, int height) {
        if(nestedList == null || nestedList.size() == 0 || height == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            if(cur.isInteger()) {
                res += cur.getInteger() * height;
            } else {
                res += dfs(cur.getList(), height - 1);
            }
        }
        return res;
    }

}
