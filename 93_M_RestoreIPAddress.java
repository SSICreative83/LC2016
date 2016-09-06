public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12)    return res;
        
        dfs(s, 0, s.length() - 1, "", res, 0);
        return res;
    }
    
    public void dfs(String s, int start, int end, String tmp, List<String> res, int count) {
        if(count == 3 && isValid(s.substring(start, end + 1))){
            tmp += s.substring(start, end + 1);
            res.add(tmp);
            return;
        } else if(count >= 3) {
            return;
        }
        
        for(int i = start + 1; i <= start + 3 && i <= end + 1; i++) {
            if(isValid(s.substring(start, i))) {
                String ntmp = tmp + s.substring(start, i) + ".";
                dfs(s, i, end, ntmp, res, count + 1);
            }
        }
        
    }
    
    public boolean isValid(String s) {
        if(s.length() == 0) return false;
        if(s.charAt(0) == '0')  return s.equals("0");
        int val = Integer.parseInt(s);
        return val > 0 && val <= 255;
    }
}
