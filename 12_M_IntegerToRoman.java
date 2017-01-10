public class Solution {
    public String intToRoman1(int num) {
        String result = "";
        
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hund = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thou = {"", "M", "MM", "MMM"};
        
        if(num >= 1000) {
            result += thou[num / 1000];
            num %= 1000;
        }
        if(num >= 100) {
            result += hund[num / 100];
            num %= 100;
        }
        if(num >= 10) {
            result += tens[num / 10];
            num %= 10;
        }
        if(num >= 0) {
            result += ones[num];
        }
        return result;
    }
    
    private static final int[] values = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    };
    
    private static final String[] symbols = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int k = num / values[i];
            for (int j = 0; j < k; j++) {
                roman.append(symbols[i]);
                num -= values[i];
            }
            i++;
        }
        return roman.toString();
    }
}
