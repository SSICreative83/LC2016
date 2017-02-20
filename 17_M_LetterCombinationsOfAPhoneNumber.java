public class Solution {
    //better DFS
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
        
        dfs(res, "", map, digits, 0);
        return res;
    }
    
    public void dfs(List<String> res, String tmp, String[] map, String digits, int start) {
        
        if(start == digits.length()) {
            res.add(tmp);
            return;
        }
        
        int curDigit = digits.charAt(start) - '0'; //2
        String curChars = map[curDigit];    //"abc"
            
        for(int j = 0; j < curChars.length(); j++) {
            String ntmp = tmp + curChars.substring(j, j + 1);
            dfs(res, ntmp, map, digits, start + 1);
        }
            
    }
    //Recursive, DFS
    public List<String> letterCombinations1(String digits) {
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
    
    //Iterative
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        
        for(int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<>();
            String cur = map[digits.charAt(i) - '0'];
            
            if(res.size() == 0) {
                for(int j = 0; j < cur.length(); j++) {
                    String ccur = cur.substring(j, j + 1);
                    tmp.add(ccur);
                }
            } else {
                for(int j = 0; j < res.size(); j++) {
                    String exist = res.get(j);
                    for(int k = 0; k < cur.length(); k++) {
                        tmp.add(exist + cur.substring(k, k + 1));
                    }
                }
            }
            
            res = tmp;
        }

        return res;
    }
}
