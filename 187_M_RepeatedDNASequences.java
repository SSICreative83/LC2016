public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        HashSet<String> set = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        
        for(int i = 0; i + 9 < s.length(); i++) {
            String cur = s.substring(i, i + 10);
            if(!set.contains(cur)) {
                set.add(cur);
            } else {
                repeated.add(cur);
            }
        }
        return new ArrayList<String>(repeated);
    }
}
