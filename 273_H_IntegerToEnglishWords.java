public class Solution {
    public String numberToWords(int num) {
        int n = num;
        if(num == 0) {
            return "Zero";
        }
        String[] ones = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        StringBuilder res = new StringBuilder();
        
        if(n >= 1000000000) {
            int bi = n / 1000000000;
            res.append(ones[bi] + " Billion ");
            n = n % 1000000000;
        }
        if(n >= 1000000) {
            int mi = n / 1000000;
            res.append(getThreeDigits(String.valueOf(mi)) + " Million ");
            n = n % 1000000;
        }
        if(n >= 1000) {
            int tho = n / 1000;
            res.append(getThreeDigits(String.valueOf(tho)) + " Thousand ");
            n = n % 1000;
        }
        res.append(getThreeDigits(String.valueOf(n)));
        return res.toString().trim();
    }
    
    public String getThreeDigits(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int num = Integer.valueOf(s);
        if(num == 0) {
            return "";
        }
        
        String res = "";
        String[] ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
        
        if(num >= 100) {
            int hun = num / 100;
            num = num % 100;
            res += ones[hun] + " Hundred";
        }
        if(num > 19) {
            int ten = num / 10;
            num = num % 10;
            res += " " + tens[ten];
        }
        if(num >= 10 && num <= 19) {
            res += " " + teens[num - 10];
            return res.trim();
        }
        if(num > 0) {
            res += " " + ones[num];
        }
        
        return res.trim();
    }
}
