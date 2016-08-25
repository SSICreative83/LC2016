public class Solution {
    public String intToRoman(int num) {
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
}
