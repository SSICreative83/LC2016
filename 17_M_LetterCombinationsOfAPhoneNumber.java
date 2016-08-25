public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        res = dfs(digits, arr, res);
        return res;
    }
    
    public List<String> dfs(String digits, String[] arr, List<String> res) {
        List<String> tmpRes = new ArrayList<>();
        if(digits.length() == 0)    return tmpRes;
        
        tmpRes = dfs(digits.substring(1), arr, tmpRes);
        int cur = digits.charAt(0) - '0';
        String chars = arr[cur];
        
        if(tmpRes.size() == 0) {
            for(int i = 0; i < chars.length(); i++) {
                String curChar = chars.substring(i, i + 1);
                res.add(curChar);
            }
        }
        
        for(int i = 0; i < chars.length(); i++) {
            String curChar = chars.substring(i, i + 1);
            for(int j = 0; j < tmpRes.size(); j++) {
                String curString = tmpRes.get(j);
                res.add(curChar + curString);
            }
        }
        return res;
    }
}
