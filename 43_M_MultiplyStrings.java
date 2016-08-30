public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null)    return null;
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0 || len2 == 0)  return "0";
        
        int[] res = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int tmp = n1 * n2 + res[i + j + 1];
                res[i + j + 1] = tmp % 10;
                res[i + j] += tmp / 10;
            }
        }
        
        StringBuilder ret = new StringBuilder();
        int start = 0, i = 0;
        for(; i < len1 + len2; i++) {
            if(res[i] != 0) {
                start = i;
                break;
            }
        }
        if(i == len1 + len2)    return "0";
 
        for(int j = start; j < len1 + len2; j++) {
            ret.append(res[j]);
        }
        return ret.toString();
    }
}
