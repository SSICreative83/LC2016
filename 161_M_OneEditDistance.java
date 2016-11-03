public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null)  return false;
        if(s.equals(t)) return false;
        
        int lenS = s.length();
        int lenT = t.length();
        if(lenS <= lenT) {  //make sure s is longer than t, lenS >= lenT
            String tmp = t;
            t = s;
            s = tmp;
            lenS = s.length();
            lenT = t.length();
        }
        if(lenS - lenT > 1) return false;
        
        for(int i = 0; i < lenT; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(lenS == lenT) {
                    return (s.substring(i + 1)).equals(t.substring(i + 1));
                } else {
                    return (s.substring(i + 1)).equals(t.substring(i));
                }
            }
        }
        
        return true;
    }
}
