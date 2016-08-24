import java.math.BigInteger;

public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0)   return 0;
        
        //eg. "-321a" symbol
        boolean positive = true;
        if(str.charAt(0) == '+' || str.charAt(0) == '-') {
            if(str.charAt(0) == '-') {
                positive = false;
            }
            str = str.substring(1);
        }
        
        int i = 0;
        BigInteger res = new BigInteger("0"); //need to use BigInteger instead of long
        while(i < str.length() && isDigit(str.charAt(i))) {
            res = res.multiply(BigInteger.valueOf(10l)).add(BigInteger.valueOf((long)(str.charAt(i) - '0')));
            i++;
        }
        
        if(!positive) { //need to set symbol before compare to Integer MIN/MAX
            res = res.multiply(BigInteger.valueOf(-1l));
        }
        
        int ret = 0;
        if(res.compareTo(BigInteger.valueOf((long)Integer.MAX_VALUE)) > 0) {    //bigger than Integer.MAX_VALUE
            ret = Integer.MAX_VALUE;
        } else if(res.compareTo(BigInteger.valueOf((long)Integer.MIN_VALUE)) < 0) {
            ret = Integer.MIN_VALUE;
        } else {
            ret = res.intValue();
        }
        
        return ret;
    }
    
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
