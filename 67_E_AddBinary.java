public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }
        
        char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();
        int i = arra.length - 1;
        int j = arrb.length - 1;
        int reslen = i > j ? i + 2 : j + 2;
        int[] res = new int[reslen];
        int k = reslen - 1;
        int plus = 0;

        while(i >= 0 || j >= 0 || plus > 0) {
            if(i < 0 && j < 0) {
                res[k] = plus;
            } else if(i < 0) {
                res[k] = (arrb[j] - '0') + plus;
                j--;
            } else if(j < 0) {
                res[k] = (arra[i] - '0') + plus;
                i--;
            } else {
                res[k] = arra[i] - '0' + arrb[j] - '0' + plus;
                i--;
                j--;
            }
            plus = 0;
            
            if(res[k] == 2) {
                res[k] = 0;
                plus = 1;
            } else if(res[k] == 3) {
                res[k] = 1;
                plus = 1;
            }
            k--;
        }
        
        
        boolean isZero = true;
        int h = 0;
        for(; h < reslen; h++) {
            if(res[h] != 0) {
                isZero = false;
                break;
            }
        }
        
        if(isZero) {
            return "0";
        }
        
        StringBuilder resb = new StringBuilder();
        for(; h < reslen; h++) {
            resb.append(res[h]);
        }
        return resb.toString();
    }
    
    // shorter solution
    public String addBinary(String a, String b) {
        if(a == null || b == null) {
            return "0";
        }
        
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
