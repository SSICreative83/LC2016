public class Solution {
    //Recursion
    public boolean isInterleave1(String s1, String s2, String s3) {
            if(s1.length() + s2.length() != s3.length()) {
                return false;
            }

            if(s1.length() == 0) {
                return s2.equals(s3);
            } else if(s2.length() == 0) {
                return s1.equals(s3);
            }
            char target = s3.charAt(0);
            if(s1.charAt(0) == target && s2.charAt(0) == target) {
                return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1));
            } else if(s1.charAt(0) == target) {
                return isInterleave(s1.substring(1), s2, s3.substring(1));
            } else if(s2.charAt(0) == target) {
                return isInterleave(s1, s2.substring(1), s3.substring(1));
            } else {
                return false;
            }
    }
    
    //DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if(s1.length() == 0) {
            return s2.equals(s3);
        } else if(s2.length() == 0) {
            return s1.equals(s3);
        }  
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++) {
            char cur = s1.charAt(i - 1);
            if(dp[i - 1][0] && cur == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }
        for(int j = 1; j <= s2.length(); j++) {
            char cur = s2.charAt(j - 1);
            if(dp[0][j - 1] && cur == s3.charAt(j - 1)) {
                dp[0][j] = true;
            }
        }
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if((dp[i - 1][j] && c1 == s3.charAt(i + j - 1)) || (dp[i][j - 1] && c2 == s3.charAt(i + j - 1)) ) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }

}
