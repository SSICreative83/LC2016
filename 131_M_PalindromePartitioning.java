public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0)    return res;
        
        List<String> tmp = new ArrayList<>();
        
        dfs(s, 0, tmp, res);
        return res;
    }
    
    public void dfs(String s, int start, List<String> tmp, List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        
        for(int j = start + 1; j <= s.length(); j++) {
            if(isPalindrome(s.substring(start, j))) {
                tmp.add(s.substring(start, j));
                dfs(s, j, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
