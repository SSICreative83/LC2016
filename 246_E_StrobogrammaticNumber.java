public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            if(!map.containsKey(cur)) {
                return false;
            } else {
                sb.append(map.get(cur));
            }
        }
        
        String newStr = sb.reverse().toString();
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) != newStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
