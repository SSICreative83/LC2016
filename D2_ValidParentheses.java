public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            
            if(cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else if (stack.empty()) { // only closing chars "}"
                return false;
            } else {
                char before = stack.pop();
                if((before == '(' && cur == ')') || (before == '[' && cur == ']') || (before == '{' && cur == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
}
