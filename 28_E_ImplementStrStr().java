public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        if(haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if(haystack.length() == 0) {
            return -1;
        }
        
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.substring(i).startsWith(needle)) {
                return i;
            }
        }
        return -1;
    }
}
