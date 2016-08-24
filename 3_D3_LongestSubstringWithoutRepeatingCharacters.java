public class Solution {
    //O(n^2)
    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0)    return 0;
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        
        for(int i = 0; i < arr.length; i++) {
            set.clear();
            for(int j = i; j < arr.length; j++) {
                char cur = arr[j];
                if(set.contains(cur)) {
                    max = Math.max(max, j - i);
                    break;
                } else {
                    set.add(cur);
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        
        return max;
    }
    
    //O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)    return 0;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        
        for(int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            if(map.containsKey(cur)) {
                int oldStart = map.get(cur);
                for(int j = start; j <= oldStart; j++) {
                    map.remove(arr[j]);
                }
                map.put(cur, i);
                start = oldStart + 1;
            } else {
                map.put(cur, i);
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }
}
