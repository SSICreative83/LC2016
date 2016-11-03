public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0)  return new int[]{-1, -1};
        
        for(int i = 0, j = numbers.length - 1; i < j; ) {
            if(numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if(numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
