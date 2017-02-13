class StrComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        String i1 = s1 + s2;    
        String i2 = s2 + s1;
        return i2.compareTo(i1);  //can use string comparasion directly, notice the reverse order
    }
}

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)    return "";
        
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, new StrComparator());
        if(arr[0].charAt(0) == '0')   return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}
