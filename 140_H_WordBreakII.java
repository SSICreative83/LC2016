
//regular DFS, TLE
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return res;
        }
        
        Set<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }
        
        List<String> tmp = new ArrayList<>();
        dfs(res, s, 0, tmp, set);
        return res;
    }
    
    public void dfs(List<String> res, String s, int start, List<String> tmp, Set<String> set) {
        if(start == s.length()) {
            addResult(res, tmp);
        }
        
        for(int j = start; j < s.length(); j++) {
            if(set.contains(s.substring(start, j + 1))) {
                List<String> ntmp = new ArrayList<>(tmp);
                ntmp.add(s.substring(start, j + 1));
                dfs(res, s, j + 1, ntmp, set);
            }
        }
    }
    
    public void addResult(List<String> res, List<String> tmp) {
        if(tmp == null || tmp.size() == 0) {
            return;
        }
        String str = "";
        for(String s : tmp) {
            str += s + " ";
        }
        str = str.trim();
        res.add(str);
    }
}
