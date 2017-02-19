public class Solution {
    // DP
    public int longestValidParentheses1(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.push(i);
            }else{
                if(!stack.empty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    if(stack.empty()){
                        max = Math.max(max, i + 1); //"()()"
                    }else{
                        max = Math.max(max, i - stack.peek());  //"(()()"
                    }
                }else{
                    stack.push(i);
                }
            }
        }
        return max;
    }
    
    /*
    1. Scan the string from beginning to end.
    2. If current character is '(', push its index to the stack. If current character is ')' and the character at the index of the top of stack is '(', we just find a matching pair so pop from the stack. Otherwise, we push the index of ')' to the stack.
    3. After the scan is done, the stack will only contain the indices of characters which cannot be matched. Then let's use the opposite side - substring between adjacent indices should be valid parentheses.
    4. If the stack is empty, the whole input string is valid. Otherwise, we can scan the stack to get longest valid substring as described in step 3.
    */
    //Time limit exceeded
    public int longestValidParentheses(String s) {
       if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        
        if(stack.isEmpty()) {
            return s.length();
        }
        
        int last = s.length();
        int first = -1;
        while(!stack.isEmpty()) {
            int pre = stack.pop();
            maxLen = Math.max(maxLen, last - pre - 1);
            last = pre;
        }
        maxLen = Math.max(maxLen, last - first - 1);

        return maxLen;
    }
}
