public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            throw new ArithmeticException("Can't devide by zero!");
        }
        //int sign = (dividend ^ divisor) > 0 ? -1 : 1;
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        long res = longDivide(a, b);
        if(res >= Integer.MAX_VALUE) {  //handle overflow
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if(sign < 0) {
            res = -res;
        }

        return (int)res;
    }
    
    public long longDivide(long dividend, long divisor) {
        if(divisor == 0) {
            throw new ArithmeticException("Can't devide by zero!");
        }
        
        if(dividend == 0 || dividend < divisor) {
            return 0;
        }
        
        long sum = divisor;
        long multiple = 1; //find max multiple which divisor * multiple <= dividend, binary search
        
        while(sum + sum <= dividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + longDivide(dividend - sum, divisor);  //recursively do it for remainder
    }
}
