public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) {
            return "";
        }
        
        String res = "";
        while(n > 0) {
            int nn = n - 1;
            int tmp = nn % 26;
            char t = (char)(tmp + 'A');

            res = t + res;
            n = nn / 26;
        }
        return res;
    }
}
