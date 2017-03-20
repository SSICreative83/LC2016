public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || s.length() == 0) {
            return true;
        }
        Set<String> dict = new HashSet<>();
        for(int i = 0; i < wordDict.size(); i++) {
            dict.add(wordDict.get(i));
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= i; j++) {
                if(dp[j - 1] && dict.contains(s.substring(j - 1, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
