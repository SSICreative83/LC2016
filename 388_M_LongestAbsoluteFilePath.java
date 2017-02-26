public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        String[] inputArr = input.split("\n");
        
        for(String s : inputArr) {
            int level = s.lastIndexOf("\t") + 1;
            
            while(level + 1 < stack.size()) {   //find parent
                stack.pop();
            }
            
            int len = stack.peek() + s.length() - level + 1;  //- '\t' + '/'
            stack.push(len);
            
            if(s.contains(".")) { //only check file
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}
