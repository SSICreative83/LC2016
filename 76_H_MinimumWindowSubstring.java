public class Solution {
  //self, for every ending position, find the shortest starting position, which makes it valid
     public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        for(int i = 0; i < t.length(); i++) {
            targethash[t.charAt(i)]++;
        }
        
        int ret = Integer.MAX_VALUE;
        String retStr = "";
        for(int start = 0, end = 0; start < s.length() && end < s.length(); end++) {
            sourcehash[s.charAt(end)]++;
            if(!isValid(sourcehash, targethash)) {  
                continue;
            }
            while(start < s.length() && start <= end && isValid(sourcehash, targethash)) {
                int curLen = end - start + 1;
                if(curLen < ret) {
                    ret = Math.min(ret, end - start + 1);
                    retStr = s.substring(start, end + 1);                    
                }

                sourcehash[s.charAt(start)]--;
                start++;
            } 
        }
        
        return retStr;
    }
  
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
