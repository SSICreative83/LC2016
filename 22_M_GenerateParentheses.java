public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)  return res;
        
        dfs(n, n, "", res);
        return res;
    }
    
    // remember the logic: if left > 0, add left parentheses; 
    // if left > right, do nothing (not valid);
    // if left < right, add right parentheses
    public void dfs(int left, int right, String tmp, List<String> res) {
        if(left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        
        if(left > 0) {
            dfs(left - 1, right, tmp + "(", res);
        }
        if(left < right) {
            dfs(left, right - 1, tmp + ")", res);
        }
        
    }
    
    // 2nd way of dfs, more straightforward logic
    public void dfs1(List<String> res, String tmp, int num_left, int num_right) {
        if(num_left == 0 && num_right == 0) {
            res.add(tmp);
            return;
        }
        if(num_left > num_right) {  //not valid case
            return;
        }
        if(num_left > 0) {
            String ntmp1 = tmp + "(";
            dfs(res, ntmp1, num_left - 1, num_right);
        }
        if(num_right > 0) {
            String ntmp2 = tmp + ")";
            dfs(res, ntmp2, num_left, num_right - 1);
        }
        
    }
}
