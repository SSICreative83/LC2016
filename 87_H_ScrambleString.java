public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length(), len2 = s2.length();
        if(len1 != len2) {
            return false;
        }
        if (s1.equals(s2)) {
            return true; 
        }
        
        //if they are not anagram, return false
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        Arrays.sort(s1arr);
        Arrays.sort(s2arr);
        String newS1 = new String(s1arr);
        String newS2 = new String(s2arr);
        if(!newS1.equals(newS2)) {
            return false;
        }
        
        for(int i = 1; i < len1; i++) { //notice i < len1, if <= will cause infinite loop
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            
            if(isScramble(s1.substring(0, i), s2.substring(len1 - i)) && isScramble(s1.substring(i), s2.substring(0, len1 - i))) {
                return true;
            }
        }
        return false;
    }
}
