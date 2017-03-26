//below solution TLE, because checking whether a substring is palindrome takes more time, need to pre-process it
public class Solution {  
    public int minCut(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            dp[i] = i - 1;
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(isPalindrom(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                } 
            }
        }
        return dp[s.length()];
    }
    
    public boolean isPalindrom(String s) {
        for(int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }    
}

// use a boolean array to store string i ~ j is palindrome or not
public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] dp = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            dp[i] = i - 1;
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                } 
            }
        }
        return dp[s.length()];
    }
    
    public boolean isPalindrom(String s) {
        for(int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }
}
