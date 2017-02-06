public class Solution {
    public boolean isIsomorphic(String s, String t) {

        //position
        HashMap<Character, Character> left = new HashMap<>();
        HashMap<Character, Character> right = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(left.containsKey(c1)) {
                char expected = left.get(c1);
                if(expected != c2) {
                    return false;
                }
            } 
            
            if(right.containsKey(c2)) {
                char expected = right.get(c2);
                if(expected != c1) {
                    return false;
                }
            }
            
            left.put(c1, c2);
            right.put(c2, c1);
        }
        
        return true;
    }
}
