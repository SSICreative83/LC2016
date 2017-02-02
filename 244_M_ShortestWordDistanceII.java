public class WordDistance {
    public Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++) {
            String cur = words[i];
            if(map.containsKey(cur)) {
                map.get(cur).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(cur, l);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int index1 = 0, index2 = 0, res = Integer.MAX_VALUE;
        while(index1 < l1.size() && index2 < l2.size()) {
            if(l1.get(index1) < l2.get(index2)) {
                res = Math.min(res, l2.get(index2) - l1.get(index1));
                index1++;
            } else if(l1.get(index1) > l2.get(index2)){
                res = Math.min(res, l1.get(index1) - l2.get(index2));
                index2++;
            } else {
                return 0;
            }
        }
       
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
