public class Solution {
  //Two pointers
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        for(int i = 0; i < t.length(); i++) {
            targethash[t.charAt(i)]++;
        }
        
        int j = 0, res = Integer.MAX_VALUE;
        String ret = "";
        //for every starting position i, find shortest string ending j, which is valid
        for(int i = 0; i < s.length(); i++) {
           while(j < s.length() && !isValid(sourcehash, targethash)) {
               sourcehash[s.charAt(j)]++;
               j++;
           }
           
           if(isValid(sourcehash, targethash)) {
               if(res > j - i) {
                    res = Math.min(res, j - i );
                    ret = s.substring(i, j );
               }
               
           }
           sourcehash[s.charAt(i)]--; 
        }
        
        return ret;
    }
    
    public boolean isValid(int[] sourcehash, int[] targethash) {
        for(int i = 0; i < sourcehash.length; i++) {
            if(sourcehash[i] < targethash[i]) {
                return false;
            }
        }
        return true;
    }
}
