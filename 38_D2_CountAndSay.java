public class Solution {
    
    //Recursive 
    public String countAndSay(int n) {
        if(n <= 0) return "";
        if(n == 1) return "1";
        
        String prev = countAndSay(n - 1);
        char[] arr = prev.toCharArray();
        StringBuilder res = new StringBuilder();
        int count = 0;
        char num = '1';
        
        for(int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            if(i == 0) {
                num = cur;
                count = 1;
                continue;
            }
            if(cur == arr[i - 1]) {
                count++;
            } else {
                res.append(count + "");
                res.append(num);
                num = cur;
                count = 1;
            }
        }
        
        //last one
        res.append(count + "");
        res.append(num);
        
        return res.toString();
    }
    
    
    //iterative
    public String countAndSay(int n) {
        if(n == 1)  return "1";
        
        String result = "1";
        
        for(int i = 1; i < n; i++){
            
            String tmp = "";
            int cnt = 1;
            int j = 1;
            
            for(; j < result.length(); j++){
                if(result.charAt(j) == result.charAt(j - 1)){
                    cnt++;
                }else{
                    tmp += (cnt + "");
                    tmp += result.charAt(j - 1); 
                    cnt = 1;
                }
                
            }
            
            tmp += (cnt + "");
            tmp += result.charAt(j - 1);
            result = tmp;
        }
        
        return result;
    }
}
