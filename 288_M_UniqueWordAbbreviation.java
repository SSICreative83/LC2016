public class ValidWordAbbr {

    Map<String, Integer> abbs;
    Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        abbs = new HashMap<>();
        set = new HashSet<>();
        for(String s : dictionary) {
            if(s == null || s.length() == 0) {
                continue;
            }
            set.add(s);
            String key = getAbbs(s);
            if(key.equals(s)) {
                continue;
            }
            if(abbs.containsKey(key)) {
                abbs.put(key, abbs.get(key) + 1);
            } else {
                abbs.put(key, 1);
            }
        }
    }
    
    public boolean isUnique(String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        String key = getAbbs(word);
        if(key.equals(word)) {
            return true;
        }
        if(set.contains(word)) {
            return abbs.get(key) <= 1;
        } 
        return !abbs.containsKey(key);
    }
    
    public String getAbbs(String s) {
            int len = s.length();
            if(len < 2) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            sb.append(len - 2);
            sb.append(s.charAt(len - 1));  
            return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
