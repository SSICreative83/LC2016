public class Solution {
    
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        if(words == null || words.length == 0)  {
            return -1;
        }
        for(int i = 0; i < words.length; i++) {
            String cur = words[i];
            
            if(map.containsKey(cur)) {
                List<Integer> l = map.get(cur);
                l.add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(cur, l);
            }
        }
        int res = Integer.MAX_VALUE;
        if(word1.equals(word2)) {
            List<Integer> l = map.get(word1);
            if(l.size() <= 1) {
                return -1;
            } else {
                int ind = 1;
                while(ind < l.size()) {
                    int index1 = l.get(ind - 1);
                    int index2 = l.get(ind);
                    res = Math.min(res, Math.abs(index1 - index2));
                    ind++;
                }
            }
        } else {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            if(l1 == null || l1.size() == 0 || l2 == null || l2.size() == 0) return -1;
            int len1 = l1.size();
            int len2 = l2.size();
            int i = 0;
            int j = 0;
            while(i < len1 && j < len2) {
                int index1 = l1.get(i); //0
                int index2 = l2.get(j); //1
                res = Math.min(res, Math.abs(index1 - index2));
                if(index1 < index2) {
                    i++;
                } else if(index1 == index2){
                    return 0;
                } else {
                    j++;
                }
            }
            
        }
        return res;
    }
}
