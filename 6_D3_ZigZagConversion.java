public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0)    return "";
        if(numRows <= 1)    return s;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(int row = 0; row < numRows; row++) {
            for(int index = row; index < len; ) {
                sb.append(s.charAt(index));
                if(row != 0 && row != numRows - 1) {
                    
                    int d = index + 2 * numRows - 2 - 2 * row;
                    if(d < len) {
                        sb.append(s.charAt(d));
                    }
                    
                }
                index += 2 * numRows - 2;
            }
        }
        return sb.toString();
    }
}
