public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        int number = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == ' ')  continue;
            if(isNum(cur)) {
                number = number * 10 + cur - '0';
            } else {
                if(sign == '+') {
                    stack.push(number);
                } else if(sign == '-') {
                    stack.push(-number);
                } else if(sign == '*') {
                    stack.push(stack.pop() * number);
                } else if(sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = cur;
            }
        }
        
        //last number
        if(sign == '+') {
            stack.push(number);
        } else if(sign == '-') {
            stack.push(-number);
        } else if(sign == '*') {
            stack.push(stack.pop() * number);
        } else if(sign == '/') {
            stack.push(stack.pop() / number);
        }
        
        int res = 0;
        for(Integer integer : stack) {
            res += integer;
        }
        return res;
    }
    
    public boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
}
