public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0)    return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String curS = strs[i];
            String key = "";

            if(!curS.isEmpty()) {
                char[] cur = curS.toCharArray();
                Arrays.sort(cur);
                key = new String(cur);   //cur.toString() is not correct!
            }

            if(map.containsKey(key)) {
                List<String> existVal = map.get(key);
                existVal.add(curS);
            } else {
                List<String> existVal = new ArrayList<>();
                existVal.add(curS);
                map.put(key, existVal);
            }
        }
        
        for(List<String> list : map.values()) {
            if(list.size() >= 1) {
                res.add(list);
            }
        }
        
        return res;
    }
}
