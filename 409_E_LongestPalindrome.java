public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] count = new int[256];
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        
        int sum = 0;
        boolean hasSingleChar = false;
        for(int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 1) {
                hasSingleChar = true;
            } 
            if(count[i] >= 2) {
                sum += count[i] / 2 * 2;
            }
        }
        
        if(hasSingleChar) {
            sum += 1;
        }
        return sum;        
    }
}
