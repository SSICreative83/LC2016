public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0) {
            return -1;
        }
        
        int index1 = -1, index2 = -1, res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            if(s.equals(word1)) {
                index1 = i;
                if(index2 != -1) { 
                    res = Math.min(res, index1 - index2);
                }
            } else if(s.equals(word2)) {
                index2 = i;
                if(index1 != -1) { 
                    res = Math.min(res, index2 - index1);
                }                
            }
        }
        
        return res;
    }
}
