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
    
    public int lengthOfLongestSubstring2(String s) {
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
    
    //using a boolean[] instead of map
    public int lengthOfLongestSubstring3(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
    
    //use an array to map char to index
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charMap[s.charAt(j)] >= i) {
                i = charMap[s.charAt(j)] + 1;
            }
            charMap[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }
}
