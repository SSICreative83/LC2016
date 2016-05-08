public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        
        String res = strs[0];
        for(int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            
            int j = 0;
            while(cur.length() > j && res.length() > j && cur.charAt(j) == res.charAt(j)) {
                j++;
            }
            
            res = res.substring(0 , j);
        }
        
        return res;
    }
}
