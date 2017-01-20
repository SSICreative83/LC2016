public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len1 = v1.length;
        int len2 = v2.length;
        int maxLen = Math.max(len1, len2);
        
        for(int i = 0; i < maxLen; i++) {
            int n1 = 0, n2 = 0;
            if(i < len1) {
              n1 = Integer.parseInt(v1[i]);
            }
            if(i < len2) {
              n2 = Integer.parseInt(v2[i]);
            }
            if(n1 == n2) {
                continue;
            } else if(n1 < n2){
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
