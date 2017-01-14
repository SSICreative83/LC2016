public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        int len = s.length();
        int start = 0, end = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(; end < len; end ++) {
            char cur = s.charAt(end);
            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                while(map.size() >= 2) {
                    char startChar = s.charAt(start);
                    if(map.get(startChar) > 1) {
                        map.put(startChar, map.get(startChar) - 1);
                    } else {
                        map.remove(startChar);
                    }
                    start++;
                }
                map.put(cur, 1);
            }
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}
